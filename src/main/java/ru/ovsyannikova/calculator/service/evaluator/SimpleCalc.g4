grammar SimpleCalc;

/* This will be the entry point of our parser. */
eval returns [double value]
    :    exp=additionExp {$value = $exp.value;}
    ;

/* Addition and subtraction have the lowest precedence. */
additionExp returns [double value]
    :    m1=multiplyExp       {$value =  $m1.value;}
         ( PLUS m2=multiplyExp {$value += $m2.value;}
         | MINUS m2=multiplyExp {$value -= $m2.value;}
         )*
    ;

/* Multiplication and division have a higher precedence. */
multiplyExp returns [double value]
    :    a1=powerExp       {$value =  $a1.value;}
         ( MULT a2=powerExp {$value *= $a2.value;}
         | DIV a2=powerExp {$value /= $a2.value;}
         )*
    ;

powerExp returns [double value]
    : u1=unaryExp {$value =  $u1.value;}
    (POWER u2=unaryExp {$value = Math.pow($u1.value, $u2.value);}
    )*
    ;

unaryExp returns [double value]
    : MINUS a=atomExp {$value = -$a.value;}
    | PLUS a=atomExp {$value = $a.value;}
    | a=atomExp {$value = $a.value;}
    ;

/* An expression atom is the smallest part of an expression: a number. Or
   when we encounter parenthesis, we're making a recursive call back to the
   rule 'additionExp'. As you can see, an 'atomExp' has the highest precedence. */
atomExp returns [double value]
    :    n=NUMBER                {$value = Double.parseDouble($n.text);}
    |    LPAREN exp=additionExp RPAREN {$value = $exp.value;}
    ;

// OPERATORS

LPAREN :'(';
RPAREN : ')';
DOT : '.';
DIV : '/';
PLUS : '+';
MINUS : '-';
MULT : '*';
POWER : '^' ;


//for both integer and real number
NUMBER
    : (DIGIT)+ ( DOT (DIGIT)+ )?
    ;

//for numbers
DIGIT
     : '0'..'9'
     ;


/* We're going to ignore all white space characters */
WS
    :   [ \t\r\n]+ -> skip
    ;