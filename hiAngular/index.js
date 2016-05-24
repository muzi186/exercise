var app = angular.module('test-app', ['ngRoute']);



//, $locationProvider
app.config(['$routeProvider', function($routeProvider){
  $routeProvider
  .when('/',{
    templateUrl:'view1.html',
    controller:'ProductDataRouteController'
  })
  .when('/views/view1', {
    templateUrl:'view1.html',
    controller:'ProductDataRouteController'
  })
  .when('/views/view2', {
    templateUrl:'view2.html',
    controller:'ProductDataRouteController'
  })
  .otherwise({
    redirectTo:'/views/view1'
  });
}]);


app.factory('ProductDataFactory', function(){
  var factory = {};
  var products = [
    {itemCode:5000, productName:'Black Backpack', price:200},
    {itemCode:4000, productName:'Fan', price:80},
    {itemCode:1000, productName:'Samsumg Mobile', price:3000.10},
    {itemCode:2000, productName:'ThinkPad Laptop', price:5000},
    {itemCode:3000, productName:'Power Banker', price:100}
  ];

  factory.getProducts = function(){
    return products;
  };

  factory.itemCodeComparator = function(actual, expected){
    if(!expected){
      return true;
    }
    var expectedItemCode = parseInt(expected);
    return actual.itemCode === expectedItemCode;
  };

  factory.priceComparator = function(actual, expected){
    if(!expected){
      return true;
    }

    var price = parseFloat(expected);
    if(actual.price >= price){
      return true;
    }

    return false;
  };

  factory.productNameComparator = function(actual, expected){
    if(!expected){
      return true;
    }

    // alert('actual:'+actual)

    if((actual.productName) && (actual.productName.slice(0, expected.length) == expected)){
      return true;
    }


    return false;
  };

  return factory;
});



app.controller('ProductDataController', function($scope, ProductDataFactory){
  $scope.products = ProductDataFactory.getProducts();

  $scope.itemCodeStr = '1000';

  $scope.itemCodeComparator = ProductDataFactory.itemCodeComparator;
});

app.controller('ProductDataController2', function($scope, ProductDataFactory){
  $scope.products = ProductDataFactory.getProducts();

  $scope.itemCodeStr = '1000';

  $scope.itemCodeComparator = ProductDataFactory.itemCodeComparator;

});

app.controller('ProductDataRouteController', function($scope, $route, $routeParams, $location,ProductDataFactory){
  $scope.products = ProductDataFactory.getProducts();
  $scope.itemCodeComparator = ProductDataFactory.itemCodeComparator;
  $scope.priceComparator = ProductDataFactory.priceComparator;
  $scope.productNameComparator = ProductDataFactory.productNameComparator;
});
