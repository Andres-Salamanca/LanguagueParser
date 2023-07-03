package LLKRecursiveDescentParser;

import LL1RecursiveDescentParser.Lexer;

public class LookaheadParser extends ParserLLK {

    public LookaheadParser(Lexer input , int k ){ super(input , k); }

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
