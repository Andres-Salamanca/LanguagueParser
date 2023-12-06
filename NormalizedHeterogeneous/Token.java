package NormalizedHeterogeneous;

public class Token{


    public static final int INVALID_TOKEN_TYPE = 0;
    public static final int PLUS = 1;
    public static final int INT = 2;
    public static final int Minus = 3;
    

    public int type;
    
    public String text;

    public Token(int type,String text){
        this.type = type; this.text = text;
    }

    public String toString(){
    
        return text;
    }

    public Token(int type) { this.type = type; }

}
