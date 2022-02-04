#!/bin/sh
ant
ant interpreter
java -cp LengthCalculatorInterpreter.jar LengthCalculatorInterpreter < beispiel.txt