socket = io.connect('http://192.168.1.191:18080')

socket.on 'message', (data) ->
  if data.welcome == 'ok'
    socket.emit 'index'

socket.on 'index', (data) ->
  jQuery.each data.data, (index, item) ->
    $('#index').append('<tr><td>' + item.key + '</td><td>' + item.value.count + '</td></tr>');

socket.on 'change', (data) ->
  console.log(data)