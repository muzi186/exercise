var counter = 0;
var handler = function(){
	console.log("this is my " + (++counter) + " time to say Hi");
}

setTimeout(handler, 3000); 
