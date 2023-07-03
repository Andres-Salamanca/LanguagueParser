package LL1RecursiveDescentParser;

public abstract class Lexer {

    public static final char EOF = (char)-1; // end of file char
    public static final int EOF_TYPE = 1; // EOF token type
    String input; 
    int p = 0; // index into input of current character
    public char chara; // current character
    
    public Lexer(String input){

        this.input = input;
        chara = input.charAt(p);

    }

    public void consume(){

        p++;
        if( p >= input.length() ) chara = EOF;
        else chara = input.charAt(p);

    }

    public void match(char x){

        if(chara == x )consume();
        else throw new Error("Expecting " + x + " found " + chara);

    }

    public abstract Token nextToken();
    public abstract String getTokenName(int tokenType);

    
}
