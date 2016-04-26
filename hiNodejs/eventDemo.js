'use strict'
var EventEmitter = require('events').EventEmitter;
var event = new EventEmitter();

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
  targetOutTime.setTime(targetOutTime.getTime() + (500));

  while(new Date() < targetOutTime){
    //do nothing;
  }
};

function TimeoutProcessor(emitter,eventName,data){
  this.emitter = emitter;
  this.eventName = eventName;
  this.data = data;

  this.process = function(){
    console.log('-- process --');
    //console.log(this.eventName);
    //console.log(this.data);
    //console.log(this);
    if(this.emitter instanceof EventEmitter){
      //console.log('true');
    }else{
      //console.log('false');
    }

    //console.log(this.emitter);
    var obj = this.emitter;
    var en = this.eventName;
    var dt = this.data;
    return function(){
      obj.emit(en,dt);
    };
  };
}

var dataTransEventName = 'DATA_TRANS';
var dataProcessEventName = 'DATA_PROCESS';
var dataProcessDoneEventName = 'DATA_DONE';

event.on(dataProcessDoneEventName, function(eventObj){
  var delimiter = '|';
  var logMsg = 'PROCESS_DONE:';
  logMsg = logMsg + dataProcessDoneEventName + delimiter;
  logMsg = logMsg + eventObj.getId() + delimiter;
  logMsg = logMsg + eventObj.getData();
  console.log(logMsg);
});

event.on(dataProcessEventName, function(eventObj){
  var delimiter = '|';
  var logMsg = 'PROCESS:';
  logMsg = logMsg + dataProcessEventName + delimiter;
  logMsg = logMsg + eventObj.getId() + delimiter;
  logMsg = logMsg + eventObj.getData();
  console.log(logMsg);
  emulateBlocking();

  event.emit(dataProcessDoneEventName, eventObj);
});

event.on(dataTransEventName, function(eventObj){
  var delimiter = '|';
  var logMsg = 'TRANS:';
  logMsg = logMsg + dataTransEventName + delimiter;
  logMsg = logMsg + eventObj.getId() + delimiter;
  logMsg = logMsg + eventObj.getData();
  console.log(logMsg);
  setTimeout(new TimeoutProcessor(event,dataProcessEventName,eventObj ).process(),0);
  //event.emit(dataProcessEventName,eventObj);
  //emulateBlocking();
});

var i=0;
for(i=0; i < 100; i++){
  event.emit(dataTransEventName, new EventData(i, ("data"+i)));
  console.log('Event sent : '+i + ' -->');
}
