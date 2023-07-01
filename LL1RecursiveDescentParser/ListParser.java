package LL1RecursiveDescentParser;

public class ListParser extends Parser {

    public ListParser(Lexer input){ super(input); }

    public void List(){
        match(ListLexer.LBRACKET);
        Elements();
        match(ListLexer.RBRACKET);
    }

    public void Elements(){

        Element();
        while(lookahead.type == ListLexer.COMMA ){
            match(ListLexer.COMMA);
            Element();
        }
    }

    public void Element(){

        if( lookahead.type == ListLexer.NAME){
            match(ListLexer.NAME);
        }
        else if( lookahead.type == ListLexer.NUMBER ){
            match(ListLexer.NUMBER);
        }
        else if( lookahead.type == ListLexer.LBRACKET ){
            List();
        }
        else{
            throw new Error("expecting name or list; found "+lookahead);
        }

    }

}
