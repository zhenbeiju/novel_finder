app = require('express')()
server = require('http').createServer(app)
io = require('socket.io').listen(server)
db = require('nano')('http://192.168.1.188:5984/novel')

server.listen(18080)

app.get '/', (req, res) ->
    res.sendfile(__dirname + '/index.html')

io.sockets.on 'connection', (socket) ->
    db.view 'index', 'books', {group: true}, (err, body) ->
        console.log "body:::"
        console.log body
        socket.emit('index', body.rows)

io.sockets.on 'message', (message, callback) ->
    console.log(message)
    socket.emit('message', {ping: 'server'})

io.sockets.on 'disconnect', () ->
    console.log('client disconnected')