grammar JPathAction;

import JPath;

locationPath 
  :  specialPath ('/'specialPath )* ('[' functionProcessor ']' )? 
  ;

functionProcessor
  :  processor '(' processorParam ( ',' processorParam )* ')'
  ;

processorParam 
  : '@' NCName 
  | variableReference
  | Literal 
  | specialName
  | INT  
  ;

specialName
  :  '@' Literal
  ;

processor
  :  'fm:' NCName
  ;
