var querystring = require('querystring');
var result = querystring.stringify({foo:'xxx', cool:['good','ex']});

console.log(result);
