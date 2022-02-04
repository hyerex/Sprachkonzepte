lexer grammar TwelveHourClock;

TwelveHourClock

fragment Hours: '0'[1-9] | '1'[0-2];
fragment Minutes: [0-5][0-9];
fragment Ampm: []* [ap]'m';
fragment Cycle: ('12') [ ]+ (('midnight' | 'noon') | ('Midnight' | 'Noon'));

DPOINT: ':';

WS: [ \t\r\n]+ -> channel(HIDDEN);