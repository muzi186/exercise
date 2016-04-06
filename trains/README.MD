How to run this program?
Please be aware that:
 the default location of input file is under "src\main\resources", named "gragh.txt".
if another location you want to specify yourself, also it supports with dynamic parameter "-Dgraghfile=<filename>".

Solution (A)
If maven installed and available, otherwise please refer to Solution (B).

#Step 1:
Open command window and change directory to the project where you place the unzipped files.

#Step 2:
Execute maven command,
mvn compile

#Step 3:
Keep on executing maven command,
mvn exec:java -Dexec.mainClass="com.recruit.tests.trains.BootStrap"
Or (while you want to specify the another location of input file)
mvn exec:java -Dexec.mainClass="com.recruit.tests.trains.BootStrap" -Dgraghfile="<file>"

#Step 4:
Just wait a moment and keep an eye on the screen and then check the outputs.

Solution (B) 
Import the project into Eclipse/IDEA but you have to adjust something yourself.
And then launch the BootStrap. 