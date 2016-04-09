var counter = 0;
var handler = function(){
	console.log("this is my " + (++counter) + " time to say Hi");
}

setInterval(handler, 1000); 
