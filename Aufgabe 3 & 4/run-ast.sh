#!/bin/sh
ant
ant ast

java -cp LengthCalculatorInterpreter.jar LengthCalculatorInterpreter < beispiel.txt