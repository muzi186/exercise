//'use strict'
var observe = require('observe.js');

var observer = new observe({});

observer.on({

  item:function(val){
    console.log('Value2:'+val);
    var that = this;

    console.log('Well Done!');
  },

  value1:function(val){
    console.log('Value1:' + val);
    var that = this;

    var items = [];
    var i=0;
    for(i=0; i<5;i++){
      items.push('item'+i);
    }

    //this.bigItems = items;
    //that.value2 = (val+' Processed.');
    console.log(items);
    items.forEach(function(v){
      console.log('v:'+v);
      console.log('this.item:'+ this.item);
      this.item = v;
    });
    //this.item = this.bigItems.shift();
  }

});

observer.value1 = 'hi';
