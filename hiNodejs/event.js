//var EventEmitter = require("events").EventEmitter;
var EventEmitter = require("./eventModule");
var getDateModule = require("./getDate.js");



var event = new EventEmitter();

event.on("heartbreak", function(){
	console.log("heart break at : " + getDateModule.getDate());
});

event.on("heartcheck", function(){
	console.log("heart check");
});

setInterval(function(){
	console.log("emit break");
	event.emit("heartbreak");
}, 2000);

setInterval(function(){
	console.log("emit check");
	event.emit("heartcheck");
},5000);
