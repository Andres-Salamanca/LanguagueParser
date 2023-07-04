package BacktrackingParser;

import LL1RecursiveDescentParser.Lexer;
import LLKRecursiveDescentParser.LookaheadLexer;

public class BacktrackingParser extends Parser{

    public BacktrackingParser(Lexer input){ super(input);}

    public void stat(){
        
        if ( speculate_stat_alt1() ) {
            List(); match(Lexer.EOF_TYPE);
        }
    
        else if ( speculate_stat_alt2() ) {
            assign(); match(Lexer.EOF_TYPE);
        }
        
        else throw new Error("expecting stat found "+LT(1));
    }

    public boolean speculate_stat_alt1(){
        boolean success = true;
        mark(); 
        try { List(); match(Lexer.EOF_TYPE); }
        catch (Exception e){ success = false; }
        release(); 
        return success;

    }

    public boolean speculate_stat_alt2() {
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

    public void List(){
        match(LookaheadLexer.LBRACKET);
        Elements();
        match(LookaheadLexer.RBRACKET);
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
