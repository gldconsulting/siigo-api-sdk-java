# Siigo API SDK Java

- Proyecto Maven de un solo módulo; Java 21. Coordenadas `co.gldconsulting:siigo-api-sdk:1.0.0-SNAPSHOT`.
- Package base `co.gldconsulting.siigo`.
- Mantener modelos en `model`, contratos Retrofit en `resource` e interfaces públicas/filtros en `service`. Las implementaciones internas y fábricas están en el package base, siguiendo la referencia de Yahoo con el nivel client eliminado.
- Partner-Id y Authorization se agregan con interceptores; no añadirlos como argumentos de los métodos de servicio.
- Conservar gestión automática, token manual reemplazable y TokenProvider externo. Una autenticación explícita debe respetar el propietario externo del ciclo de vida.
- Los filtros son propios de cada operación. El período de compras se filtra localmente por date tras recorrer todas las páginas; no inventar filtros remotos.
- Usar BigDecimal para importes y LocalDate para fechas contables. No convertir errores o paginación incompleta en resultados vacíos exitosos.
- Validar con `./mvnw clean verify`. Las pruebas HTTP locales no requieren credenciales; las reales son optativas y solo de lectura.
- Mantener secretos fuera del repositorio. Conservar la licencia MIT de GLD Consulting.
- Consultar README y `src/main/resources/siigo-api-coverage.json` para cobertura y discrepancias de documentación. La publicación es manual, mediante el perfil release y Central Portal.

- Para consultar comprobantes por fecha contable, usar `JournalService.getJournalsByDate`: filtrado local inclusivo tras paginación completa. En la prueba real del 18-11-2026 Siigo ignoró los filtros remotos de journals `date_start`, `date_end` y `document_id`; `name` sí funcionó. Conservar la distinción entre diagnóstico remoto y validación del SDK.

- Investigación de filtros de journals 18-11-2026: 14 URLs comparadas con SDK y HTTP directo dieron iguales totales/IDs; fechas contables y document_id no restringieron resultados. No atribuir una causa interna confirmada. JournalsFilter.setDateStart/End(LocalDate) ahora usa límites UTC RFC3339; las sobrecargas de texto conservan timestamps explícitos. README documenta la evidencia y la prueba optativa JournalFilterContractLiveIT.
