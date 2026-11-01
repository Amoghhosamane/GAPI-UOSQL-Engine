grammar UOSQL;

// Parser Rules
uosqlProgram: statement* EOF ;

statement: connectStmt ';'
         | traverseStmt ';'
         | findStmt ';'
         | entityStmt ';'
         ;

connectStmt: CONNECT entityRef edgeAttrs? (chainLink)* ;

chainLink: edgeOp edgeAttrs? entityRef edgeAttrs? ;

edgeOp: '->'
      | '<-'
      | '<->'
      | '--'
      ;

edgeAttrs: '[' attrPair (',' attrPair)* ']' ;

traverseStmt: TRAVERSE entityRef (traverseLink)+ (WHERE conditionExpr)? ;

traverseLink: edgeOp edgeAttrs? entitySelector edgeAttrs? ;

findStmt: FIND (KIND | '*') (WHERE conditionExpr)? ;

entityStmt: entityDecl ;

entityDecl: KIND '(' STRING (',' entityAttrs)? ')' ;

entityRef: KIND '(' STRING ')' ;

entitySelector: KIND ('(' (STRING | '*') ')')? ;

entityAttrs: '{' attrPair (',' attrPair)* '}'
           | '[' attrPair (',' attrPair)* ']'
           ;

attrPair: IDENT '=' value ;

conditionExpr: conditionTerm (OR conditionTerm)* ;
conditionTerm: conditionFactor (AND conditionFactor)* ;
conditionFactor: IDENT compOp value
               | '(' conditionExpr ')'
               ;

compOp: '==' | '=' | '!=' | '>=' | '<=' | '>' | '<' | 'CONTAINS' ;

value: STRING
     | NUMBER
     | BOOLEAN
     ;

// Lexer Rules
CONNECT: 'CONNECT' ;
TRAVERSE: 'TRAVERSE' ;
FIND: 'FIND' ;
WHERE: 'WHERE' ;
AND: 'AND' ;
OR: 'OR' ;

KIND: 'Human'
    | 'Organization'
    | 'Project'
    | 'Workflow'
    | 'Repository'
    | 'AIModel'
    | 'DigitalTwin'
    ;

BOOLEAN: 'true' | 'false' | 'True' | 'False' ;

IDENT: [a-zA-Z_][a-zA-Z0-9_\-]* ;

STRING: '"' ( '\\"' | ~["\r\n] )* '"'
      | '\'' ( '\\\'' | ~['\r\n] )* '\''
      ;

NUMBER: '-'? [0-9]+ ('.' [0-9]+)? ;

WS: [ \t\r\n]+ -> skip ;

