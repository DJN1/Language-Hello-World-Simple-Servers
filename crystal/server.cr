require "http/server"
require "json"

host = "localhost"
port = 8080

server = HTTP::Server.new do |context|
    context.response.content_type = "application/json"
    context.response.print({"request": "#{context.request.method} #{context.request.path}", "message": "hello from crystal"}.to_json)
end

puts "Server running at http://#{host}:#{port}"
server.bind_tcp(host, port)
server.listen
