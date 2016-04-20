function Animal(){
	var inner = 'abcd';

	this.name = 'A';

	this.setName = function(v){

		this.name = v;

	}

	this.getName = function(){
		return this.name;
	}
}


Animal.prototype.sort = 'Animal';

Animal.prototype.setSort = function(v){
	this.sort = v;
	console.log('setSort:' +  this.name);
}

Animal.prototype.getSort = function(){
	return this.sort;
}

var animal1 = new Animal();
var animal2 = new Animal();

animal1.setName('animal1');
animal2.setName('animal2');

console.log(animal1.getName());
console.log(animal2.getName());

animal1.setSort('Sort1');
animal2.setSort('Sort2');

console.log(animal1.getSort());
console.log(animal2.getSort());

console.log(animal1.getName === animal2.getName);
console.log(animal1.getSort === animal2.getSort);

console.log(animal1.name === animal2.name);
console.log(animal1.sort === animal2.sort);


