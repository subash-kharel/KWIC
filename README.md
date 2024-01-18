# KWIC Implentations Shared Memory

This is the implentation of KWIC using shared memory. This setup only contains a single class called KWIC with a main method. The work for this was done by Preston Kelly and Subash Kharel.

## Folder Structure

The workspace contains one folder, where:

- `src`: the folder to maintain source code and input.txt

## Information on the Program and how it works

This program works by reading an input file and will produce teh output within the terminal. This output should be aphabetically sorted and circular shifted on each line.

There are currently 1 input files to choose from:
- [input.txt](src/input.txt)

If you wish to test a differnt input, please update this file before running the program.

The main function for the applicaiton can be found at the following [location](src/KWIC.java#L9). 

The changes are accomplished by the following methods used and can be found at the following locations:
- [readLinesFromFile] (src/KWIC.java#L23)
- [circularShift] (src/KWIC.java#L37)
- [alphabetizing](src/KWIC.java#L62)
- [displayKWICIndex](src/KWIC.java#L84)
