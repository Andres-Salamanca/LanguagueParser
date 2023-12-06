package NormalizedHeterogeneous;

public class AddNode extends ExprNode{

    public AddNode(ExprNode left,Token token,ExprNode right) {
        super(token);
        addChildren(left);
        addChildren(right);
    }
    
    public int getEvalType() { 
        ExprNode left = (ExprNode)children.get(0);
        ExprNode right = (ExprNode)children.get(1);
        if ( left.getEvalType()==tINTEGER && right.getEvalType()==tINTEGER ) {
            return tINTEGER;
        }
        if ( left.getEvalType()==tVECTOR && right.getEvalType()==tVECTOR ) {
            return tVECTOR;
        }
        return tINVALID;
    }

    
}
