package BacktrackingParser;
import java.util.List;

import LL1RecursiveDescentParser.Lexer;
import LL1RecursiveDescentParser.Token;

import java.util.ArrayList;


public abstract class Parser{

    Lexer input;          
    List<Integer> markers; 
    List<Token> lookahead; 
    int p = 0; 

    public Parser(Lexer input){
        this.input = input;
        markers = new ArrayList<Integer>();
        lookahead = new ArrayList<Token>();
        sync(1);
    }
    public void sync(int i ){

        if(p+i-1 > (lookahead.size()-1)){
            int n = (p+i-1) - (lookahead.size()-1);
            fill(n);
        }

    }

    public void fill(int n ){
        for (int i=0;i<=n;i++){ lookahead.add(input.nextToken()); }
    }
    public void consume(){
        p++;

        if(p == lookahead.size() && !isSpeculating()){

            p=0;
            lookahead.clear();
        }
        sync(1);
    }

    public boolean isSpeculating() { return markers.size() > 0; }
    public int mark(){
        markers.add(p);
        return p;
    }
    public void release(){
        int marker = markers.get(markers.size()-1);
        markers.remove(markers.size()-1);
        seek(marker);
    }
    public void seek(int marker){
        p = marker;
    }

    public Token LT(int i ){ sync(i); return lookahead.get(p+i-1);}
    public int LA(int i){ return LT(i).type;}
    public void match(int x) {

        if ( LA(1) == x ) consume();
        else throw new Error("expecting "+
                       input.getTokenName(x)+" found "+LT(1));


    }
}