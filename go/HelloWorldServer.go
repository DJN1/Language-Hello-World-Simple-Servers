package main
import (
    "fmt"
    "net/http"
)


func main() {
    const host = "localhost"
    const port = 8080
    http.HandleFunc("/", requestHandler)
    fmt.Print(fmt.Sprintf("Server running at http://%s:%d\n", host, port))
    http.ListenAndServe(fmt.Sprintf("%v:%v", host, port), nil)
}

func requestHandler(w http.ResponseWriter, r *http.Request) {
    w.Header().Set("Content-Type", "application/json")
    fmt.Fprintln(w, "{\"request\": \"" + fmt.Sprintf("%v %v", r.Method, r.URL) + "\", \"message\": \"hello from go\"}")
}
