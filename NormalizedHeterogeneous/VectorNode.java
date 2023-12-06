package NormalizedHeterogeneous;

import java.util.List;

public class VectorNode extends ExprNode{

    public VectorNode(Token token,List<ExprNode> elements) {
        super(token);
        evalType =tVECTOR;
        for (ExprNode e : elements){

            addChildren(e);
        }
    }

    
    
}
