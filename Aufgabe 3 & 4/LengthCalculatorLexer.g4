//LengthCalculatorLexer.g4
lexer grammar LengthCalculatorLexer;

Length: Number ('.' Number)? [ ]+ Unit;
Unit: ('ly'|[kcd]?'m');

fragment Number: ([0-9])+;

PLUS: '+';
MINUS: '-';
LPAREN: '(';
RPAREN: ')';
POINT: '.';
DPOINT: ':';

WS: [ \t\r\n]+ -> channel(HIDDEN);


