package main
import (
    "fmt"
    "net/http"
    "encoding/json"
)

type Response struct {
    Request string
    Message string
}


func main() {
    const host = "localhost"
    const port = 8080
    http.HandleFunc("/", requestHandler)
    fmt.Print(fmt.Sprintf("Server running at http://%s:%d\n", host, port))
    http.ListenAndServe(fmt.Sprintf("%v:%v", host, port), nil)
}

func requestHandler(w http.ResponseWriter, r *http.Request) {
    json.NewEncoder(w).Encode(Response{Request: fmt.Sprintf("%v %v", r.Method, r.URL), Message: "hello from Go"})
}
