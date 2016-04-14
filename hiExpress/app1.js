var express = require("express");
var app = express();

app.get("*", function(request, response){
	console.log(request.hostname, request.path);

	response.send("request.host获取主机名,request.path获取请求路径名！");

});


app.listen(8090);
