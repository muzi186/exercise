var util = require('util');

process.stdin.setEncoding('utf8');

process.stdin.on('readable', ()=>{
	var chunk = process.stdin.read();
	
	process.stderr.write('here\n');

	if(chunk !== null){
	//	process.stdout.write("data:"+ chunk);
	}else{
		console.log('null');
	}	

});

process.stdout.on('data', (data)=>{
	var capturedData = util.format('captureedData:%s', data);
	console.log(capturedData);

});
