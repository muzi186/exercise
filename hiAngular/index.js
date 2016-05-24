var app = angular.module('test-app', []);


app.factory('ProductDataFactory', function(){
  var factory = {};
  var products = [
    {itemCode:5000, name:'Black Backpack', price:200},
    {itemCode:4000, name:'Fan', price:80},
    {itemCode:1000, name:'Samsumg Mobile', price:3000.10},
    {itemCode:2000, name:'ThinkPad Laptop', price:5000},
    {itemCode:3000, name:'Power Banker', price:100}
  ];

  factory.getProducts = function(){
    return products;
  };

  return factory;
});

app.controller('ProductDataController', function($scope, ProductDataFactory){
  $scope.products = ProductDataFactory.getProducts();

  $scope.itemCodeStr = '1000';

  $scope.itemCodeComparator = function(actual, expected){
    if(!expected){
      return true;
    }
    var expectedItemCode = parseInt(expected);
    return actual.itemCode === expectedItemCode;
  };
});
