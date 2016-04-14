var express = require("express");
var app = express();
var path = require("path");

app.set("views", __dirname);

app.set("view engine", "html");

app.engine(".html",require("ejs").__express);

app.use(express.static(require("path").join(__dirname, "public")));


app.get("/", function(request, response){
	response.render("index");
});

app.get("/login", function(req, res){
	res.render("login");

});


app.get("/home", function(req, res){
	res.render("home");
});

app.listen(8090);
