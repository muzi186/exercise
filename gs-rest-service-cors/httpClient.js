'use strict'
const http = require('http');
var options = {
  hostname: 'localhost',
  port: 8080,
  path: '/greeting',
  method: 'GET'
  //localAddress: '127.0.0.1:9000'
};

var req = http.request(options, function(res){
  console.log('res:' + res);
  console.log('Status:'+res.statusCode);
});

req.end();
