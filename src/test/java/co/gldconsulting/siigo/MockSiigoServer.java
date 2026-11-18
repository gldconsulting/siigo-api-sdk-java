package co.gldconsulting.siigo;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

final class MockSiigoServer implements AutoCloseable {
    record Request(String method, String path, String query, Map<String, List<String>> headers, String body) {
        String header(String name) { return headers.entrySet().stream().filter(e -> e.getKey().equalsIgnoreCase(name)).map(e -> e.getValue().getFirst()).findFirst().orElse(null); }
    }
    record Reply(int status, String body, String contentType) {
        Reply(int status, String body) { this(status, body, "application/json"); }
    }
    private final HttpServer server;
    private final ExecutorService executor = Executors.newCachedThreadPool();
    private final LinkedBlockingQueue<Function<Request, Reply>> replies = new LinkedBlockingQueue<>();
    final List<Request> requests = new CopyOnWriteArrayList<>();
    MockSiigoServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
        server.setExecutor(executor); server.createContext("/", this::handle); server.start();
    }
    void enqueue(int status, String body) { replies.add(r -> new Reply(status, body)); }
    void enqueue(Function<Request, Reply> reply) { replies.add(reply); }
    String url() { return "http://127.0.0.1:" + server.getAddress().getPort() + "/"; }
    private void handle(HttpExchange exchange) throws IOException {
        try {
            Request request = new Request(exchange.getRequestMethod(), exchange.getRequestURI().getPath(), exchange.getRequestURI().getRawQuery(),
                    Map.copyOf(exchange.getRequestHeaders()), new String(exchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8));
            requests.add(request);
            Function<Request, Reply> next = replies.poll(2, TimeUnit.SECONDS);
            Reply reply = next == null ? new Reply(500, "{\"error\":\"unexpected request\"}") : next.apply(request);
            byte[] bytes = reply.body().getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", reply.contentType());
            exchange.sendResponseHeaders(reply.status(), bytes.length); exchange.getResponseBody().write(bytes);
        } catch (InterruptedException interrupted) { Thread.currentThread().interrupt(); }
        finally { exchange.close(); }
    }
    @Override public void close() { server.stop(0); executor.shutdownNow(); }
}
