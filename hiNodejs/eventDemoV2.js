'use strict'
var EventEmitter = require('events').EventEmitter;
var emitter = new EventEmitter();

function EventData(id,data){
  this.id = id;
  this.data = data;

  this.getId = function(){
    return this.id;
  };

  this.getData = function(){
    return this.data;
  };
}

var emulateBlocking = function(){
  var targetOutTime = new Date();
  targetOutTime.setTime(targetOutTime.getTime() + (300));

  while(new Date() < targetOutTime){
    //do nothing;
  }
};

var logEventData = function(eventName, eventObj){
  var delimiter = '|';
  var logMsg = 'PROCESS_DONE:';
  logMsg = logMsg + eventName + delimiter;
  logMsg = logMsg + eventObj.getId() + delimiter;
  logMsg = logMsg + eventObj.getData();
  console.log(logMsg);
}

var dataTransEventName = 'DATA_TRANS';
var dataProcessEventName = 'DATA_PROCESS';
var dataProcessDoneEventName = 'DATA_DONE';

emitter.addListener(dataTransEventName,function(data){
  logEventData(dataTransEventName, data);
});

emitter.addListener(dataProcessEventName,function(data){
  logEventData(dataProcessEventName, data);
  emulateBlocking();
});

emitter.addListener(dataProcessDoneEventName,function(data){
  logEventData(dataProcessDoneEventName, data);
});

var i=0;
for(i=0; i < 100; i++){
  emitter.emit(dataTransEventName, new EventData(i, ("data"+i)));
  console.log('Event sent : '+i + ' -->');
}
