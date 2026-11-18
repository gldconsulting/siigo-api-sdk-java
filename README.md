# Siigo API SDK para Java

SDK de **GLD Consulting S.A.S.** para la API REST de Siigo Colombia, con Java 21, Maven, Retrofit, OkHttp y Jackson. Licencia MIT.

```xml
<dependency>
  <groupId>co.gldconsulting</groupId>
  <artifactId>siigo-api-sdk</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

El repositorio contiene la versión de desarrollo. Esta referencia Maven no implica que el artefacto ya esté publicado en Central. Para consumirlo localmente, ejecutar `./mvnw install`; para una liberación pública se utilizará una versión sin `-SNAPSHOT`.

## Organización

Se conserva la separación de responsabilidades del SDK de Yahoo DSP de referencia, eliminando el nivel `client`:

```text
src/main/java/co/gldconsulting/siigo/
  SiigoApi.java                     # Fachada y builder
  CommunicationConfig.java         # Configuración compartida de HTTP
  CommunicationFactory.java        # Transporte Retrofit/OkHttp
  SerializationConfig.java
  SerializationFactory.java
  AuthenticationManager.java       # Sesión en memoria
  *ServiceImpl.java                 # Implementaciones internas
  interceptor/                     # Partner-Id y Bearer
  model/                           # DTOs tipados y envolturas de respuesta
  resource/
    AuthenticationResource.java
    accounting/                    # Contratos HTTP
    catalog/
    reporting/
  service/
    AuthenticationService.java
    TokenProvider.java
    accounting/                    # Interfaces públicas y filtros por operación
    catalog/
    reporting/
src/test/java/co/gldconsulting/siigo/
  *Test.java                       # Pruebas unitarias
  *IT.java                         # Integración HTTP local y pruebas reales optativas
  examples/                        # Ejemplos ejecutables de lectura
```

`resource` declara rutas, verbos y cuerpos de la API. `service` ofrece las operaciones al consumidor del SDK. Las implementaciones conectan ambas capas. No se requiere Spring ni otro contenedor.

## Partner-Id y autenticación

El Partner-Id registrado para la integración se configura **una sola vez**. `PartnerIdInterceptor` lo añade a las solicitudes, incluida `/auth`. `AuthenticationInterceptor` añade `Authorization: Bearer …` a las operaciones protegidas. Ningún método de servicio exige pasar estos headers.

Cada instancia de `SiigoApi` mantiene su propia sesión. La configuración y el token no se comparten globalmente entre empresas. Se debe cerrar la instancia al terminar o al apagar la aplicación.

### Gestión automática

```java
import co.gldconsulting.siigo.CommunicationConfig;
import co.gldconsulting.siigo.SiigoApi;
import co.gldconsulting.siigo.model.AuthenticationCredentials;

var credentials = new AuthenticationCredentials()
    .setUsername(System.getenv("SIIGO_USERNAME"))
    .setAccessKey(System.getenv("SIIGO_ACCESS_KEY"));

try (SiigoApi siigo = SiigoApi.builder()
        .withCommunicationConfig(CommunicationConfig.builder()
            .setPartnerId(System.getenv("SIIGO_PARTNER_ID")))
        .setCredentials(credentials)
        .build()) {
    var taxes = siigo.getCatalogService().getTaxes();
}
```

El primer acceso protegido obtiene el token. El SDK usa `expires_in` para renovarlo antes de vencer, con una sesión sincronizada para llamadas concurrentes. Una lectura rechazada con 401 puede renovar el token y repetirse **una sola vez**. Las operaciones de escritura no se repiten automáticamente. La autenticación nunca lleva el header Bearer.

### Token manual y reemplazo en ejecución

```java
try (SiigoApi siigo = SiigoApi.builder()
        .withCommunicationConfig(CommunicationConfig.builder()
            .setPartnerId(System.getenv("SIIGO_PARTNER_ID")))
        .setAccessToken(System.getenv("SIIGO_ACCESS_TOKEN"))
        .build()) {
    siigo.getCatalogService().getTaxes();
    // Cuando la aplicación obtenga otro token:
    siigo.setAccessToken(nuevoToken);
}
```

Se proporciona el token **sin** el prefijo `Bearer`. `setAccessToken` cambia a gestión manual, incluso si antes había credenciales automáticas: el SDK no renueva ni sustituye ese token. Un 401 se entrega como error al consumidor.

### TokenProvider del desarrollador

```java
import java.util.concurrent.atomic.AtomicReference;

AtomicReference<String> tokenActual = new AtomicReference<>(tokenInicial);
try (SiigoApi siigo = SiigoApi.builder()
        .withCommunicationConfig(CommunicationConfig.builder()
            .setPartnerId(partnerId))
        .setTokenProvider(tokenActual::get)
        .build()) {
    siigo.getCatalogService().getTaxes();
    tokenActual.set(tokenRenovadoPorLaAplicacion);
    siigo.getCatalogService().getTaxes();
}
```

El interceptor consulta el proveedor en cada solicitud. Por defecto, `TokenProvider.refreshAfterUnauthorized` no hace nada; la aplicación conserva completamente el ciclo de vida. Se puede implementar ese hook para autorizar un único reintento de lectura después de obtener un token nuevo. También se puede reemplazar el proveedor con `siigo.setTokenProvider(...)`.

`getAuthenticationService().authenticate(credentials)` permite solicitar un token explícitamente y actualiza la caché automática, pero **respeta** el token manual o proveedor externo que esté activo. Para volver a la gestión del SDK, usar `useAutomaticAuthentication()` después de haber configurado o utilizado credenciales.

## Compras, filtros y paginación

```java
import co.gldconsulting.siigo.service.accounting.PurchasesFilter;
import java.time.LocalDate;

var page = siigo.getPurchaseService().getPurchases(
    new PurchasesFilter().setPage(1).setPageSize(100));

var all = siigo.getPurchaseService().getAllPurchases(
    new PurchasesFilter().setPageSize(100));

var august2026 = siigo.getPurchaseService().getPurchasesByDate(
    LocalDate.of(2026, 8, 1),
    LocalDate.of(2026, 8, 31),
    new PurchasesFilter().setPageSize(100));
```

`getPurchases` obtiene una página. `getAllPurchases` recorre desde la página 1 y comprueba el total, el número de registros, los identificadores únicos y los enlaces de continuación. Una inconsistencia genera una excepción, en vez de presentar datos parciales como un recorrido completo. `getAll…` toma una copia de los filtros y no modifica el objeto del consumidor.

El filtro del período de compras es **local**, inclusivo y usa `date`, la fecha contable del documento. Se recorren todas las páginas sin asumir orden. No se envían filtros remotos de fecha no confirmados para `/v1/purchases`. Una compra creada en octubre con `date` de agosto se incluye; una compra cuya fecha contable sea octubre queda fuera.

Los filtros de otros recursos solo contienen sus parámetros publicados. Por ejemplo, `InvoicesFilter` ofrece `document_id`, cliente, nombre, fechas y paginación; `QuotationsFilter` ofrece los filtros propios de cotizaciones. `Partner-Id`, credenciales y tokens no son filtros de negocio.

## Servicios disponibles

| Acceso desde `SiigoApi` | Operaciones |
| --- | --- |
| `getAuthenticationService()` | Autenticación explícita |
| `getCatalogService()` | Impuestos, otros ingresos, descuentos, bodegas, formas de pago, usuarios, tipos de documento, centros de costo, precios y activos fijos |
| `getInventoryCategoryService()` | Listar, crear y editar categorías de inventario |
| `getProductService()` | Crear, consultar, listar, editar y eliminar productos |
| `getCustomerService()` | Crear, consultar, listar y editar terceros |
| `getInvoiceService()` | Crear, editar, listar, consultar, anular, eliminar, consultar errores DIAN, PDF/XML, correo y lote de facturas |
| `getQuotationService()` | Crear, consultar, listar, editar y eliminar cotizaciones |
| `getCreditNoteService()` | Crear, consultar, listar y PDF de notas crédito |
| `getPurchaseService()` | Crear, consultar, listar, editar y eliminar compras; recorrido y filtro local por fecha |
| `getSupportDocumentService()` | Crear, consultar, editar y eliminar documentos soporte |
| `getJournalService()` | Crear, consultar y listar comprobantes contables; recorrido y filtro local por fecha |
| `getVoucherService()` | Crear, consultar y listar recibos de caja; variante MiscIncome |
| `getPaymentReceiptService()` | Crear, consultar, listar y eliminar pagos/egresos |
| `getReportService()` | Balance de prueba general, por tercero y cuentas por pagar |
| `getWebhookService()` | Crear, consultar, editar y eliminar suscripciones |

El inventario verificable está en [`siigo-api-coverage.json`](src/main/resources/siigo-api-coverage.json): **69 combinaciones distintas de método y ruta**, más selectores y variantes de documentos. `DocumentKind` proporciona `FV`, `FC`, `NC`, `RC`, `RP`, `CC`, `C` y `DS`.

### Modelos y contratos incompletos

Los importes usan `BigDecimal`; las fechas de documentos usan `LocalDate`. Los DTOs son Java beans con setters encadenables. Cada modelo conserva campos adicionales de Siigo mediante `ApiModel`, accesibles en `getAdditionalProperties()` y `setAdditionalProperty(...)`.

Las respuestas PDF/XML contienen base64 y `DocumentFile.getBytes()` permite decodificarlo. Los reportes retornan `file_id` y `file_url`; el SDK no descarga automáticamente esa URL.

Se mantienen explícitas las discrepancias conocidas de las fuentes:

- El listado de egresos publica filtros temporales, pero no un esquema completo de respuesta: `getPaymentReceipts` retorna `JsonNode`.
- La respuesta del lote de facturas no tiene un contrato completo en las fuentes aportadas: `InvoiceBatchResponse` conserva los campos que retorne el servidor. Cada factura del lote tiene su propio DTO, incluida su clave de idempotencia.
- Cuentas por pagar publica `due_date_end` en el texto y `date_end` en el esquema. Ambos están disponibles; el filtro rechaza activarlos simultáneamente. El consumidor debe confirmar con Siigo cuál aplicar.
- Los parámetros de paginación de webhooks se respaldan en los enlaces del ejemplo oficial.
- No se exponen las operaciones heredadas sin respaldo documental `DELETE /v1/customers/{id}` y `GET /v1/asset-groups`, ni una edición de egresos con ruta no publicada.

## Errores e idempotencia

Los fallos HTTP se entregan como `SiigoApiException`: `getStatusCode()` conserva el estado y `getError()` ofrece método, ruta y detalles JSON del servidor. El estado 0 identifica un problema de transporte o decodificación. Los errores no se convierten en listas vacías.

Las creaciones documentadas de facturas, notas crédito, comprobantes contables y recibos de caja admiten una clave de idempotencia propia del documento:

```java
var created = siigo.getJournalService().createJournal(journalRequest, "documentoUnico123");
```

La misma clave se conserva al reintentar ese documento. No es una configuración global. El SDK no repite escrituras por errores HTTP ni por fallos de conexión. Los 429 se entregan al consumidor; la aplicación debe coordinar el límite publicado de 100 solicitudes por minuto por empresa y su política de espera.

## Configuración HTTP

`CommunicationConfig` permite ajustar URL base, tiempos de conexión/lectura/escritura, logger e interceptores adicionales. Los tiempos de lectura y escritura predeterminados son dos minutos. Las URLs remotas usan HTTPS; HTTP se permite para servidores locales de pruebas.

El modo de diagnóstico registra headers, con `Authorization` y `Partner-Id` ocultos; no registra cuerpos de autenticación. Las credenciales y tokens no se incluyen en `toString()`. Los redirects automáticos están deshabilitados: las credenciales se destinan al host de la API configurado.

## Compilación y pruebas

Requiere **JDK 21**. El wrapper utiliza Maven 3.9.9.

```sh
./mvnw clean verify
```

`test` ejecuta las pruebas unitarias. `verify` añade las pruebas de integración HTTP con un servidor local: autenticación compartida, vencimiento, 401, tokens manuales/proveedores externos, filtros, paginación, duplicados, errores, precisión monetaria, catálogos y respuestas de documentos. No requieren una cuenta de Siigo.

Hay dos pruebas optativas de lectura contra Siigo real:

```sh
export SIIGO_LIVE_TESTS=true
export SIIGO_PARTNER_ID=...
export SIIGO_USERNAME=...
export SIIGO_ACCESS_KEY=...
./mvnw verify
```

Se puede usar `SIIGO_ACCESS_TOKEN` en lugar de usuario y access key. Estas pruebas consultan tipos de compras y una página de compras; no crean ni modifican comprobantes. Sin `SIIGO_LIVE_TESTS=true`, permanecen deshabilitadas. Los secretos se proporcionan desde el entorno, no desde archivos versionados.

### Verificación de compras de un período

`PurchasesPeriodLiveIT` verifica la autenticación automática y el uso compartido del token, los headers agregados por los interceptores, dos recorridos completos con 100 y 50 compras por página y la selección inclusiva por `Purchase.date`. Compara los identificadores y los importes con una selección independiente del conjunto completo. Requiere usuario y access key; no utiliza un token manual.

Con `SIIGO_PARTNER_ID`, `SIIGO_USERNAME` y `SIIGO_ACCESS_KEY` disponibles en el entorno:

```sh
SIIGO_PURCHASES_PERIOD_TEST=true \
SIIGO_PURCHASES_FROM=2026-08-01 \
SIIGO_PURCHASES_TO=2026-08-31 \
./mvnw verify
```

Las fechas predeterminadas son el 1 y el 31 de agosto de 2026. El informe se guarda en `target/live-verification/purchases-<desde>-<hasta>.json`, con las páginas consultadas y las compras del período, sin credenciales ni tokens. La prueba solo ejecuta `POST /auth` y `GET /v1/purchases`; no modifica comprobantes. El filtro de fechas se aplica localmente después de recorrer todas las páginas, porque el contrato de compras solo documenta `page` y `page_size` como parámetros remotos. Su consumo es una autenticación, una página de referencia y dos recorridos completos; elegir un tamaño de cuenta compatible con el límite de solicitudes de Siigo. Sin `SIIGO_PURCHASES_PERIOD_TEST=true`, permanece deshabilitada.

### Verificación de comprobantes contables de un período

Para consultar por **fecha contable**, usar el método que recorre todas las páginas y filtra localmente por `Journal.date`, con ambos límites incluidos:

```java
var journals = siigo.getJournalService().getJournalsByDate(
    LocalDate.of(2026, 8, 1), LocalDate.of(2026, 8, 31),
    new JournalsFilter().setPageSize(50));
```

En la prueba real del **18 de noviembre de 2026**, la API devolvió los 378 comprobantes de la empresa al enviar `date_start`/`date_end` para agosto, tanto con fechas simples como con fechas RFC3339. También ignoró `document_id`; el filtro por `name` sí seleccionó el comprobante esperado. Son observaciones de esa ejecución, no una garantía sobre otras cuentas o cambios futuros del servidor. El [contrato oficial](https://developers.siigo.com/docs/siigoapi/journal-entry/3-get-journals) documenta esos parámetros; `getJournals` y `getAllJournals` los envían tal como se configuran y conservan la respuesta del servidor. `getJournalsByDate` evita depender de los filtros remotos de fecha y rechaza `date_start`/`date_end` en el filtro adicional para que el período se defina exclusivamente con `from` y `to`.

`JournalsPeriodLiveIT` comprueba autenticación, headers, paginación con 100 y 50 registros por página y el resultado local contra una selección independiente. Registra por separado los diagnósticos de fechas, nombre y tipo de comprobante del servidor; un diagnóstico `respected: false` no representa un filtro remoto aprobado.

Con las credenciales disponibles en el entorno:

```sh
SIIGO_JOURNALS_PERIOD_TEST=true \
SIIGO_JOURNALS_FROM=2026-08-01 \
SIIGO_JOURNALS_TO=2026-08-31 \
./mvnw verify
```

El informe, sin claves ni tokens, queda en `target/live-verification/journals-<desde>-<hasta>.json`; contiene los comprobantes del período, las páginas consultadas y el resultado de cada filtro remoto. Para exigir también el cumplimiento del contrato remoto, añadir `SIIGO_ASSERT_REMOTE_JOURNAL_FILTERS=true`: la prueba falla si algún filtro remoto no coincide con la selección independiente. Las fechas predeterminadas son agosto de 2026. La prueba solo autentica y consulta, y espacia las solicitudes; permanece deshabilitada sin `SIIGO_JOURNALS_PERIOD_TEST=true`.

### Contraste del filtro de comprobantes con HTTP directo

El 18-11-2026 se contrastaron **14 casos** con el SDK y, para cada uno, una solicitud independiente con `java.net.http.HttpClient`, usando exactamente la URL codificada observada, el mismo token y el mismo Partner-Id. El cliente directo pidió `Cache-Control: no-cache`. Todos los casos coincidieron en HTTP 200, `total_results` e identificadores ordenados de la primera página. El informe `target/live-verification/journal-filter-contract.json` conserva las URLs, los resultados y el catálogo de tipos, sin tokens ni credenciales.

Se verificaron fechas simples, UTC RFC3339, offset `-05:00`, cada límite por separado, un período futuro sin coincidencias, dos tipos existentes (9140 y 9150) y uno inexistente. Las fechas contables y `document_id` devolvieron los 378 registros, incluyendo tipos distintos del solicitado. El filtro `name` devolvió un documento, incluso combinado con una fecha futura o un tipo que lo excluía. `created_start`/`created_end` para agosto produjo cero registros; filtra creación, no fecha contable, y no sustituye a `date_start`/`date_end`.

El [contrato oficial de journals](https://developers.siigo.com/docs/siigoapi/journal-entry/3-get-journals) define `date_start` y `date_end` como query strings RFC3339. `document_id` aparece en la tabla narrativa como número, pero falta en el esquema interactivo y en su ejemplo cURL; el [texto de Apiary](https://siigoapi.docs.apiary.io/introduction/manejo-de-errores) también lo menciona en la sección de listado, con una anotación de tipo inconsistente. Esto documenta una discrepancia entre documentación y servicio. No demuestra la causa interna, que requiere confirmación de Siigo.

Se corrigieron las sobrecargas `setDateStart(LocalDate)` y `setDateEnd(LocalDate)` de `JournalsFilter` para generar `T00:00:00Z` y `T23:59:59Z`, respectivamente, cubriendo el día contable en UTC. Los setters de texto conservan el valor explícito; `JournalFilterEncodingIT` verifica su transmisión sin duplicados ni doble codificación, incluyendo un offset positivo. La corrección de formato no resuelve el filtrado del servidor, puesto que las pruebas RFC3339 explícitas ya reproducían la discrepancia. Las sobrecargas `LocalDate` de fechas de creación/actualización conservan su comportamiento previo de fecha simple; para seguir el formato date-time de ese esquema se deben proporcionar timestamps explícitos con los setters de texto.

Para repetir el contraste, en la misma cuenta GLD que contiene el comprobante de referencia `CC-1-229` y los tipos de la prueba, proporcionar las credenciales en el entorno y ejecutar:

```sh
SIIGO_JOURNAL_FILTER_CONTRACT_TEST=true ./mvnw verify
```

Esta prueba valida la equivalencia del transporte y registra el comportamiento remoto; no certifica que Siigo aplique esos filtros. Para verificar estrictamente el cumplimiento remoto usar la opción `SIIGO_ASSERT_REMOTE_JOURNAL_FILTERS` de `JournalsPeriodLiveIT` descrita arriba. No se enviaron mensajes a soporte ni se modificaron comprobantes.

## Publicación en Maven Central

La configuración utiliza el **Central Publisher Portal**, no el antiguo servicio OSSRH. La publicación se activa únicamente con el perfil `release` y la fase `deploy`. `autoPublish` está desactivado, de modo que el bundle queda pendiente de revisión/liberación en el Portal.

1. Verificar el namespace `co.gldconsulting` en Central y obtener un token de publicación.
2. Configurar el servidor Maven con id `central` y la firma GPG fuera del repositorio. Hay una plantilla en `.maven/settings.xml.example`.
3. Cambiar la versión a la versión de liberación sin `-SNAPSHOT`, revisar los cambios y ejecutar `./mvnw clean verify`.
4. Preparar JAR, fuentes y Javadoc sin publicar: `./mvnw -Prelease -Dgpg.skip=true verify`.
5. Cuando corresponda publicar: `./mvnw -Prelease clean deploy`. Revisar el deployment en Central antes de liberarlo.

El workflow `maven.yml` compila y prueba en Java 21. `release.yml` solo se dispara manualmente, requiere una versión de liberación y usa el entorno `maven-central` y secretos configurados por el mantenedor.

## Fuentes y licencia

- [Contrato oficial en Apiary](https://siigoapi.docs.apiary.io/).
- [Portal oficial de Siigo Colombia](https://developers.siigo.com/docs/siigoapi/).
- Colección Postman revisada previamente para este SDK.
- Organización lógica de referencia: clon local `yahoo-dsp-api-sdk-java`, con código de Siigo implementado para esta API y sin el nivel `client`.
- [Publicación con el plugin oficial de Central](https://central.sonatype.org/publish/publish-portal-maven/).

Copyright 2026 GLD Consulting S.A.S. [MIT](LICENSE). Los scripts de Maven Wrapper conservan sus avisos de licencia Apache 2.0.
