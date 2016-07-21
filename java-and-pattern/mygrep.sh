#!/bin/bash
JAVA="$JAVA_HOME/bin/java"
MAIN_CLASS="com.gl.designpattern.decorator.grep.MyGrep"
CP="target/classes"
#$JAVA -version
$JAVA -cp $CP $MAIN_CLASS $*
