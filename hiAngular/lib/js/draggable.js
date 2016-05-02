'use strict'
const drag = angular.module('drag', []);
drag.directive('draggable',function($document){
  var sX = 0;
  var sY = 0;
  var x = 0;
  var y = 0;
  return function(scope, element, attr){
    element.css({
      position:'relative',
      border:'1px solid red',
      backgroundColor:'lightgrey',
      cursor:'pointer'
    });

    element.bind('mousedown', function(event){
      sX = event.screenX - x;
      sY = event.screenY - y;
      $document.bind('mousemove', mousemove);
      $document.bind('mouseup', mouseup);
    });

    function mousemove(event){
      y = event.screenY - sY;
      x = event.screenX - sX;
      element.css({
        top:y+'px',
        left:x+'px'
      });
    }

    function mouseup(){
      $document.unbind('mousemove', mousemove);
      $document.unbind('mouseup', mouseup)
    }
  };
});
