package NormalizedHeterogeneous;

public abstract class ExprNode extends Ast{

    public static final int tINVALID = 0; // invalid expression type
    public static final int tINTEGER = 1; // integer expression type
    public static final int tVECTOR = 2;// vector expression type
    int evalType;

    public int getEvalType(){return evalType;}
    public ExprNode(Token token){
        super(token);
    }

    public String toString() {
        
        if ( evalType != tINVALID ) {
            return super.toString()+"<type="+
            (evalType == tINTEGER ? "tINTEGER" : "tVECTOR")+">";
        }

        return super.toString();
    }
        

}
