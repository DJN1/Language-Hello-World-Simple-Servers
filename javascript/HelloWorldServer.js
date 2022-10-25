const http = require("http");

const host = "localhost";
const port = 8080;

const requestListener = function (req, res) {
    res.setHeader("Content-Type", "application/json");
    res.writeHead(200);
    res.end(JSON.stringify({
        request: `${req.method} ${req.url}`,
        message: "hello from JS"
    }));
}

const server = http.createServer(requestListener);

server.listen(port, host, () => {
    console.log(`Server running at http://${host}:${port}`);
});
