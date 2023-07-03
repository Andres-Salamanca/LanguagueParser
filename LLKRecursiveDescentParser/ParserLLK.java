package LLKRecursiveDescentParser;
import LL1RecursiveDescentParser.Token;
import LL1RecursiveDescentParser.Lexer;

public abstract class ParserLLK {
    public Lexer input;
    public Token[] lookahead;
    public int k;
    public int p =0;

    public ParserLLK(Lexer input , int k ) { 
        
        this.input = input;
        this.k = k;
        lookahead = new Token[k];
        for (int i =1 ; i<=this.k ; i++){ consume(); }


    }

    public void match(int x){

        if( LA(1)== x ){ consume(); }
        else{
            throw new Error("Expecting " + input.getTokenName(x) + " ; Found " + LT(1));
        }
        
    }

    public void consume(){

        lookahead[p] = input.nextToken();
        p = (p+1) % k;

    }

    public Token LT(int i) {return lookahead[(p+i-1) % k];} // circular fetch
    public int LA(int i ){ return LT(i).type; }
    
}
