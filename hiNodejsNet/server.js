var net = require('net');

var server = net.createServer();

server.on('connection', (s) => {
  console.log('connected at ' + ( new Date() ) );
  s.on('data', function(data){
    console.log('Received data :' + data);
    s.write('hi client!', 'utf-8', function(){
      console.log('send to client');
    });
  });
});

server.listen(8099, function(){
  console.log('listening...');
});
