import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.Headers;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

public class HelloWorldServer {
    
    static final String host = "localhost";
    static final int port = 8080;

    public static void main(String args[]) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(HelloWorldServer::handler);
        System.out.println("Server running at http://" + host + ":" + port);
        server.start();
    }

    private static void handler(HttpExchange request) throws IOException {
        String requestMethod = request.getRequestMethod();
        String requestPath = request.getRequestURI().toString();
        Headers headers = request.getResponseHeaders();
        headers.add("Content-Type", "application/json");
        String response = "{\"request\": \"" + requestMethod + " " + requestPath + "\", \"message\": \"hello from java\"}";
        request.sendResponseHeaders(200, response.length());
        OutputStream responseStream = request.getResponseBody();
        try {
            responseStream.write(response.getBytes(Charset.defaultCharset()));
        } finally {
            responseStream.close();
        }
    }
}
