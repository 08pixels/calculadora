package calculadora;

import java_cup.runtime.Symbol;

%%
%cup
%%

"+"                 {return new Symbol(JMSymbols.PLUS);		}
"-"					{return new Symbol(JMSymbols.MINUS);	}
"*"					{return new Symbol(JMSymbols.TIMES);	}
"/"					{return new Symbol(JMSymbols.DIVIDE);	}

[0-9]+              {return new Symbol(JMSymbols.INT, new Integer(yytext())); }

[ \t\r\n\f]         {/* ignore white space */}
.                   {System.err.println("Illegal character: "+yytext());}