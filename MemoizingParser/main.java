package MemoizingParser;

import LLKRecursiveDescentParser.LookaheadLexer;

public class main {

    public static void main(String[] args) {

    LookaheadLexer lexer = new LookaheadLexer("[a,b]=[c,d]"); // parse arg
    BacktrackParser parser = new BacktrackParser(lexer);
    parser.stat();

    }
    
}
