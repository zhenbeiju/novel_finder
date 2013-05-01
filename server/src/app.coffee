app = require('express')()
server = require('http').createServer(app)
io = require('socket.io').listen(server)

server.listen(18080)

app.get '/', (req, res)->
    res.sendfile(__dirname + '/index.html')

io.sockets.on 'connection', (socket) ->
    socket.emit('message', {ping: 'server'})
    socket.on 'my other event', (data)->
        console.log(data)

io.sockets.on 'message', (message, callback) ->
    console.log(message)
    socket.emit('message', {ping: 'server'})

io.sockets.on 'disconnect', () ->
    console.log('disconnect')