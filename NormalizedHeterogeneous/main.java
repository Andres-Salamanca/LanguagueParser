package NormalizedHeterogeneous;

public class main {
    public static void main(String[] args) {

        Token plus = new Token(Token.PLUS,"+");
        Token one = new Token(Token.INT,"1");
        Token two = new Token(Token.INT,"2");
        Token minus = new Token(Token.PLUS,"-");
        Token three = new Token(Token.INT,"3");
        ExprNode root = new AddNode(new IntNode(one), plus, new IntNode(two));
        ExprNode node  = new AddNode(new IntNode(three), minus, new IntNode(three));
        root.addChildren(node);
        System.out.println(root.treeToString());
    }
    
}