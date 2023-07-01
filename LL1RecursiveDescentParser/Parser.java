package LL1RecursiveDescentParser;

public abstract class Parser {
    public Lexer input;
    public Token lookahead;

    public Parser(Lexer input) { this.input = input; consume(); }

    public void match(int x){

        if(lookahead.type == x ){ consume(); }
        else{
            throw new Error("Expecting " + input.getTokenName(x) + " ; Found " + lookahead);
        }
        
    }

    public void consume(){ lookahead = input.nextToken(); }
    
}
