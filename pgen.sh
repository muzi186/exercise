#!/bin/bash
echo $#
if [ $# -lt 1 ]; then
cat<<HELP
	At least the project name should be provided.
	USAGE: pgen <prject-name>
HELP

exit 0
fi

echo "project name:" $1
mkdir -p $1/src/main/java
mkdir -p $1/src/main/resources
mkdir -p $1/src/test/java
mkdir -p $1/src/test/resrouces


exit 0

