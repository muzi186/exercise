var os = require('os');

var platform = os.platform();
var release = os.release();
var type = os.type();
var arch = os.arch();

console.log('platform:' + platform);
console.log('release:'+release);
console.log('type:'+type);
console.log('arch:'+arch); 
