#!/bin/sh
#Compile java files and place classes in bin/test dir
javac -d bin -cp "lib/junit-4.13.1.jar;." out/production/FiveCardPoker/*.java src/*.java
#Create java package
jar cfm FiveCardPoker.jar test-manifest.txt -C bin test -C bin main
#Run java package
java -jar FiveCardPoker.jar