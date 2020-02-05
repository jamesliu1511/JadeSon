grammar JTemplate;

@header {
	package com.jade.path.antlr;
}
  
locationPath 
  :  step ('/'step )* 
  ;

step  
  : NCName 
  | Literal
  ;

Literal  :  '"' ~'"'* '"'
  |  '\'' ~'\''* '\''
  ;

FLOAT : '-'? [0-9]+'.'[0-9]+;

INT : '-'? [0-9]+;

NCName  :  NCNameStartChar NCNameChar*
  ;

Number  : '-'? Digits ('.' Digits?)?
  |  '.' Digits
  ;

WS  :  (' '|'\t'|'\n'|'\r')+ ->skip
  ;

fragment
Digits  :  ('0'..'9')+
  ;

fragment
NCNameStartChar
  :  'A'..'Z'
  |   '_'
  |  'a'..'z'
  |  '\u00C0'..'\u00D6'
  |  '\u00D8'..'\u00F6'
  |  '\u00F8'..'\u02FF'
  |  '\u0370'..'\u037D'
  |  '\u037F'..'\u1FFF'
  |  '\u200C'..'\u200D'
  |  '\u2070'..'\u218F'
  |  '\u2C00'..'\u2FEF'
  |  '\u3001'..'\uD7FF'
  |  '\uF900'..'\uFDCF'
  |  '\uFDF0'..'\uFFFD'
  ;

fragment
NCNameChar
  :  NCNameStartChar | '-' | '.' | '0'..'9'
  |  '\u00B7' | '\u0300'..'\u036F'
  |  '\u203F'..'\u2040'
  ;