package LLKRecursiveDescentParser;

public class main {
    public static void main(String[] args) {
        LookaheadLexer lexer = new LookaheadLexer("[a,b=c,,[d,e]]"); // parse arg
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.List(); 
    }
    
}
