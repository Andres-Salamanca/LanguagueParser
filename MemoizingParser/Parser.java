package MemoizingParser;

import java.util.List;
import java.util.Map;

import LL1RecursiveDescentParser.Lexer;
import LL1RecursiveDescentParser.Token;

import java.util.ArrayList;


public abstract class Parser{

    Lexer input;          
    List<Integer> markers; 
    List<Token> lookahead; 
    int p = 0; 
    public static final int FAILED = -1;


    public abstract void clearMemo();

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
            clearMemo();
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

    public boolean alreadyParsedRule(Map<Integer, Integer> memoization){
        
        Integer memoI = memoization.get(index());
        if ( memoI==null ) return false;
        int memo = memoI.intValue();
        System.out.println("parsed list before at index "+index()+
                           "; skip ahead to token index "+memo+": "+
                           lookahead.get(memo).text);
        if ( memo==FAILED ) throw new Error("error funcion alreadyparsedRule");;
        // else skip ahead, pretending we parsed this rule ok
        seek(memo);
        return true;

    }

    public void memoize(Map<Integer, Integer> memoization,
                        int startTokenIndex, boolean failed)
    {
        // record token just after last in rule if success
        int stopTokenIndex = failed ? FAILED : index();
        memoization.put(startTokenIndex, stopTokenIndex);
    }

    public int index() { return p; }
}