package MemoizingParser;

import LL1RecursiveDescentParser.Lexer;
import LLKRecursiveDescentParser.LookaheadLexer;
import java.util.HashMap;
import java.util.Map;

public class BacktrackParser extends Parser{

    public BacktrackParser(Lexer input){ super(input);}
    Map<Integer, Integer> list_memo = new HashMap<Integer, Integer>();


    public void stat(){
        
        if ( speculate_stat_alt1() ) {
            List(); match(Lexer.EOF_TYPE);
        }
    
        else if ( speculate_stat_alt2() ) {
            System.out.println("predict alternative 2");
            assign(); match(Lexer.EOF_TYPE);
        }
        
        else throw new Error("expecting stat found "+LT(1));
    }

    public boolean speculate_stat_alt1(){
        System.out.println("attempt alternative 1");
        boolean success = true;
        mark(); 
        try { List(); match(Lexer.EOF_TYPE); }
        catch (Exception e){ success = false; }
        release(); 
        return success;

    }

    public boolean speculate_stat_alt2() {
        System.out.println("attempt alternative 2");
        boolean success = true;
        mark(); 
        try { assign(); match(Lexer.EOF_TYPE); }
        catch (Exception e) { success = false; }
        release(); 
        return success;
    }

    public void assign() {
        List(); match(LookaheadLexer.EQUALS); List();
    }

    public void _List(){
        System.out.println("parse list rule at token index: "+index());
        match(LookaheadLexer.LBRACKET);
        Elements();
        match(LookaheadLexer.RBRACKET);

    }

    public void clearMemo() {
        list_memo.clear();
    }

    public void List(){
        
        boolean failed = false;
        int startTokenIndex = index();
        if( isSpeculating() && alreadyParsedRule(list_memo) ){
            return ;
        }
        try { _List(); }
        catch (Exception e) { failed = true; throw e; }
        finally {
            //  succeed or fail, must record result if backtracking
            if (isSpeculating()) memoize(list_memo, startTokenIndex, failed);
        }

    }
    public void Elements(){

        Element();
        while(LA(1) == LookaheadLexer.COMMA ){
            match(LookaheadLexer.COMMA);
            Element();
        }
    }

    public void Element(){

        if( LA(1)==LookaheadLexer.NAME && LA(2)==LookaheadLexer.EQUALS){

            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);

        }
        else if ( LA(1)==LookaheadLexer.NAME ) {    
            match(LookaheadLexer.NAME);
        }
        else if( LA(1) == LookaheadLexer.NUMBER ){
            match(LookaheadLexer.NUMBER);
        }
        else if( LA(1) == LookaheadLexer.LBRACKET ){
            List();
        }
        else{
            throw new Error("expecting name or list; found "+LT(1));
        }

    }


}
