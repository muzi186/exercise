var generateClosure = function(){
	var count = 0;

	var counter = function(){
//		var count = 0;
		count++;
		return count;
	}

	return counter;
}

var counter = generateClosure();

console.log(counter());
console.log(counter());
console.log(counter());
