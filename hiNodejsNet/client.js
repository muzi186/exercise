'use strict'
var net = require('net');
var socket = net.connect(8099, function(){
  console.log('client connecting...');

});

console.log('socket:'+ socket);

socket.on('data', function(data){
  console.log('returned data:' + data);
});

socket.write('Hello Server!', 'utf-8', function(){
  console.log('write to server');
});
