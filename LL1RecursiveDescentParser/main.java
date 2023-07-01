package LL1RecursiveDescentParser;

public class main {
    public static void main(String[] args) {

        ListLexer lexer = new ListLexer("[a, b ,1,2,3,4,[b,5,a]]");
        ListParser parser = new ListParser(lexer);
        parser.List();
        // Token t = lexer.nextToken();
        // while ( t.type != Lexer.EOF_TYPE ) {
        //     System.out.println(t);
        //     t = lexer.nextToken();
        // }
        // System.out.println(t); // EOF
                
    }
    
}
