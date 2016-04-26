var observe = require('observe.js');

var producer = {
  items:[]
};

var consumer = {
  item:''
};

var producerObs = observe(producer);
var consumerObs = observe(consumer);

producerObs.on();
