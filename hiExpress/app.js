var express = require("express");

var app = express();

app.all("*", function(request, response, next){
	
	response.writeHead(200, {"Content-Type":"text/html;charset=utf-8"});
	next();
});

app.get("/", function(req,res){
//	res.send("Welcome to hiExpress HomePage!");	

	res.end("Welcome to hiExpress HomePage!");	

});

app.get("/about", function(req,res){
	//res.send("Welcome to hiExpress AboutPage");

	res.end("Welcome to hiExpress AboutPage");
});

app.get("*", function(req,res){
//	res.send("404 error - Page not found!");

	res.end("404 error - Page not found!");
});

var server = app.listen(8090, function(){
	var host = server.address().address;
	var port = server.address().port;


	console.log("app listening at http://%s:%s", host, port);


});
