'use strict'
const http = require('http');
var options = {
  hostname: 'localhost',
  port: 8080,
  path: '/greeting',

  //socketPath: '127.0.0.1:9090'
  //localAddress: '127.0.0.1:9000'
  method: 'GET'
};

var printGreeting = function(g){
  console.log('g:'+g);
  console.log('g.id:' + g.id);
  console.log('g.content:' + g.content);
};

var req = http.request(options, function(res){
  console.log('res:' + res);
  console.log('Status:'+res.statusCode);

  res.on('error', (err)=>{
    console.log('ERROR');
    console.log(err);
  });

  res.on('data', (chunk)=>{
    console.log('body:'+chunk);
    var jsonObj = JSON.parse(chunk);
    printGreeting(jsonObj);
  });
});

req.on('error', (err)=>{
  console.log('ERROR while request:' + err);
  throw new Error('Request failed.' + err);
});

req.end();
