var fs = require('fs');

var errHandler = function(err){
	if(err){
		throw err;
	}else{
		console.log("Created successfully!");
	}
}

var data = "hello 中国";
var filename = "fstest.txt";
var encoding = "utf8";

fs.writeFile(filename, data, encoding, errHandler);

fs.appendFile(filename, "辽宁舰", (err)=>{
	if(err){
		throw err;
	}

	console.log("Appended successfully!");
});
