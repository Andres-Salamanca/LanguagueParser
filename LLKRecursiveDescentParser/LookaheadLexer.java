package LLKRecursiveDescentParser;

import LL1RecursiveDescentParser.Lexer;
import LL1RecursiveDescentParser.Token;


public class LookaheadLexer extends Lexer{
    public static int NAME = 2;
    public static int COMMA = 3;
    public static int LBRACKET = 4;
    public static int RBRACKET = 5;
    public static int NUMBER = 6;
    public static int EQUALS = 7;
    public static String[] TokensNames = { "n/a" , "<EOF>" , "NAME" , "COMMA" , "LBRACKET" , "RBRACKET","NUMBER","EQUALS"}; 
    public String getTokenName(int x ){ return TokensNames[x];}
    public LookaheadLexer(String input){super(input);}
    boolean isLETTER() { return chara>='a'&&chara<='z' || chara>='A'&&chara<='Z'; }
    boolean isNumber() { return chara>='0'&&chara<='9';}

    public Token nextToken() {

        while ( chara!= EOF ) {
            switch ( chara ) {
                case ' ': case '\t': case '\n': case '\r': WhiteSpace(); continue;
                case ',' : consume(); return new Token(COMMA, ",");
                case '[' : consume(); return new Token(LBRACKET, "[");
                case ']' : consume(); return new Token(RBRACKET, "]");
                case '=' : consume(); return new Token(EQUALS, "=");
                default:
                    if ( isLETTER() ) return NAME();
                    else if(isNumber())return NUMBER();
                    throw new Error("invalid character: "+chara);
            }
        }
        return new Token(EOF_TYPE,"<EOF>");
    }

    Token NAME(){
        StringBuilder buf = new StringBuilder();
        do{ buf.append(chara); consume(); }while(isLETTER());
        return new Token(NAME, buf.toString());
    }

    Token NUMBER(){
        StringBuilder buf = new StringBuilder();
        do{ buf.append(chara); consume(); }while(isNumber());
        return new Token(NUMBER, buf.toString());
    }

    void WhiteSpace(){

        while ( chara==' ' || chara=='\t' || chara=='\n' || chara=='\r' ) consume();

    }
    
}
