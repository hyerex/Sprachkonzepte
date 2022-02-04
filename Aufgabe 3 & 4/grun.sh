#!/bin/sh
c="java -cp LengthCalculator.jar org.antlr.v4.gui.TestRig LengthCalculatorLexer tokens -tokens $1"
c="java -cp LengthCalculator.jar org.antlr.v4.gui.TestRig LengthCalculator tokens -tokens $1 > ${1%.*}-tokens.txt"
echo $c
eval $c

gui="java -cp LengthCalculator.jar org.antlr.v4.gui.TestRig LengthCalculator start -gui $1"
echo $gui
eval $gui