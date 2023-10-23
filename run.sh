##!/bin/sh
# Define the main Java class and source file
MAIN_CLASS="out\production\FiveCardPoker\FiveCardPoker"
SOURCE_FILE="src\FiveCardPoker.java"

# Compile the Java source code
if javac "$SOURCE_FILE"; then
    echo "Compilation successful."

    # Run the Java program
    java "$MAIN_CLASS"
else
    echo "Compilation failed."
fi