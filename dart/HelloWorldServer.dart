import "dart:io";
import "dart:convert";

void main() async {
    final host = "localhost";
    final port = 8080;
    var server = await HttpServer.bind(host, port);
    print("Server running at http:\/\/$host:$port");
    await for (var request in server) {
        request.response.headers.add(HttpHeaders.contentTypeHeader, "application/json");
        request.response.write(jsonEncode({"request": "${request.method} ${request.uri}", "message": "hello from dart"}));
        request.response.close();
    }
}
