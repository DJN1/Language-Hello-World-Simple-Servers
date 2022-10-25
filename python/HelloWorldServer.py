#!/usr/bin/env python3

from http.server import BaseHTTPRequestHandler, HTTPServer
import json

host = "localhost"
port = 8080

class handler(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.send_header("Content-type", "application/json")
        self.end_headers()
        self.wfile.write(json.dumps({"request": f"{self.command} {self.path}", "message": "hello from python"}).encode("utf-8"))


if __name__ == '__main__':
    server = HTTPServer((host, port), handler)
    print(f"Server running at http://{host}:{port}")
    server.serve_forever()
