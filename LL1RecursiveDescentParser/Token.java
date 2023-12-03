package LL1RecursiveDescentParser;

public class Token{

    public int type;
    public String text;
    public Token(int type,String text){

        this.type = type; this.text = text;

    }
    public String toString(){

        String tname =  ListLexer.TokensNames[type];
        return "<'"+text+"',"+tname+">";

    }
    public Token(int type) { this.type = type; }

}
