package LL1RecursiveDescentLexer;

public class main {
    public static void main(String[] args) {

        ListLexer lexer = new ListLexer("[a, b ,1,2,3,4,[2,3]]");
        Token t = lexer.nextToken();
        while ( t.type != Lexer.EOF_TYPE ) {
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t); // EOF
                
    }
    
}
