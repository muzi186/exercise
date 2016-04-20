var fs = require('fs');

var encoding = 'utf-8';

var filename = 'file.txt';

function readfileHandler(err, data){
	if(err){
		console.log(err);
	}else{
		console.log(data);
	}
}


fs.readFile(filename , encoding , readfileHandler);

console.log('end');
