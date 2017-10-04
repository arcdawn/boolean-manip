package lexer;

import java.util.Optional;
import lexer.ParserException.ErrorCode;

/**
 *
 * @author super
 */
public final class DisjunctiveExpression {
    private final Factor factor;
    private final boolean positive;
    DisjunctiveExpression(boolean status, Factor idOrComp){
        positive = status;
        factor = idOrComp;
    }
    public boolean getPositive(){
        return positive;
    }
    public final DisjunctiveExpression negate(){   
        return new DisjunctiveExpression(!this.positive,this.factor);
    }
    public final String conjunctiveRepresentation(){
        
        if(factor.conjunctiveRepresentation().negationGetter().equals(this.positive)){
            return "not "+ factor.conjunctiveRepresentation().representationGetter();
        }
        return factor.conjunctiveRepresentation().representationGetter();
    }
    private static DisjunctiveExpression checkIDvsCF(boolean positiveValue, LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
        if(token.getType().equals(Token.Type.ID)){
                return new DisjunctiveExpression(positiveValue ,Identifier.Builder.build(token));
            }
        else{
            ParserException.verify(Optional.ofNullable(token));
            //capital b
            return new DisjunctiveExpression(positiveValue ,CompoundFactor.Builder.build(token, lexer));
        }
    }
    public static final class Builder{
        public static final DisjunctiveExpression build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
            boolean positiveValue = true;
            if(token.getType().equals(Token.Type.NOT)){
                positiveValue = false;
                //parser exception verification
                LocationalToken tok = lexer.nextValid().get();
                return checkIDvsCF(positiveValue, tok, lexer);
            }
            else{
                return checkIDvsCF(positiveValue, token, lexer);
            }
           
        }
    }
}
