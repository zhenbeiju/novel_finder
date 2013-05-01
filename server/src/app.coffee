app = require('express')()
server = require('http').createServer(app)
io = require('socket.io').listen(server)
db = require('nano')('http://192.168.1.188:5984/novel')

server.listen(18080)

book_feed = db.follow({since: 'now'})
book_feed.on 'change', (change) ->
    console.log change
    db.view 'index', 'books', {group: true, keys: [ change.id ]}, (err, body) ->
        io.sockets.emit 'change', body

book_feed.follow()

app.get '/', (req, res) ->
    res.sendfile(__dirname + '/index.html')

app.get '/client.js', (req, res) ->
    res.sendfile(__dirname + '/client.js')

io.sockets.on 'connection', (socket) ->
    socket.emit 'message', { welcome: "ok" }
    socket.on 'index', (data) ->
        db.view 'index', 'books', { group: true }, (err, body) ->
            socket.emit 'index', {'type': 'books', 'data' : body.rows}
    socket.on 'book', (data) ->
        db.view 'index', 'chapters', { group: true, keys: [data.id] },  (err, body) ->
            socket.emit 'book', {'type' : 'chapters', 'data' : body.rows}