package Homogeneous;

public class main {
    public static void main(String[] args) {

        Token plus = new Token(Token.PLUS,"+");
        Token minus = new Token(Token.PLUS,"-");

        Token one = new Token(Token.INT,"1");
        Token two = new Token(Token.INT,"2");
        Token three = new Token(Token.INT,"3");
        Ast root = new Ast(minus);
        root.addChildren(new Ast(plus));
        root.addChildren(new Ast(plus));
        root.children.get(0).addChildren(new Ast(one));
        root.children.get(0).addChildren(new Ast(two));
        root.children.get(1).addChildren(new Ast(two));
        root.children.get(1).addChildren(new Ast(three));
        System.out.println("(1+2)-(2+2)tree: "+root.treeToString());

        Ast list = new Ast(); // make nil node as root for a list
        list.addChildren(new Ast(one));
        list.addChildren(new Ast(two));
        System.out.println("1 and 2 in list: "+list.treeToString());
    }
    
}