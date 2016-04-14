var fs = require("fs");

fs.readFile("fstest.txt","utf8", function(err,data){
	if(err){
		throw err;
	}else{
		console.log(data);
	}
});

console.log("End and exit");
