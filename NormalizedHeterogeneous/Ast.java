package NormalizedHeterogeneous;

import java.util.ArrayList;
import java.util.List;



public class Ast {

    Token token;
    List<Ast> children;
    public Ast() {
    }
    public Ast(Token token) {
        this.token = token;
    }

    public Ast(int tokenType) {
        this.token = new Token(tokenType);
    }

    public int getNodeType(){ return this.token.type; }
    
    public void addChildren(Ast newChild){
        if(this.children == null){ this.children = new ArrayList<Ast>(); }
        children.add(newChild);
    }

    public Boolean isNil(){return token == null;}

    public String toString(){return token!=null?token.toString():"nil";}

    public String treeToString(){
        if(this.children == null || this.children.size() == 0){
            return this.toString();
        }

        StringBuilder buf = new StringBuilder();

        if(!isNil()){
            buf.append("(");
            buf.append(this.toString());
            buf.append(" ");
        }

        for(Ast child : children){
            buf.append(" ");
            buf.append(child.treeToString());

        }

        if ( !isNil() ) buf.append(")");
        return buf.toString();


    }
}
