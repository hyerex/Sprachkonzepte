#!/bin/sh
ant
ant ast

java -cp LengthCalculatorToAst.jar LengthCalculatorToAst < beispiel.txt