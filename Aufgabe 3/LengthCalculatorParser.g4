// LengthCalculatorParser.g4
parser grammar LengthCalculatorParser;

options { tokenVocab=LengthCalculatorLexer; }

start : unit? expr EOF;

expr : primary | expr (PLUS | MINUS) primary;

primary : LPAREN expr RPAREN | length;

unit : Unit;

length : Length;