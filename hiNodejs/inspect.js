var util = require('util');

var obj = {a:'aa',b:'bb',f:function(){}};

var ret = util.inspect(obj);

console.log('obj:' + ret);
