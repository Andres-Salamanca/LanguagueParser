package BacktrackingParser;

import LLKRecursiveDescentParser.LookaheadLexer;


public class main {
    public static void main(String[] args) {
        LookaheadLexer lexer = new LookaheadLexer(" [a,b]=[c,d]"); 
        BacktrackingParser parser = new BacktrackingParser(lexer);
        parser.stat();
    }
}
