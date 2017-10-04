
package lexer;

import java.util.Optional;

/**
 *
 * @author super
 */
public class CompoundFactor implements Factor{
    private final DisjunctiveExpression leftExpression;
    private final DisjunctiveExpression rightExpression;
    CompoundFactor(DisjunctiveExpression input1, DisjunctiveExpression input2){
        leftExpression = input1;
        rightExpression = input2;
    }

    @Override
    public String toString() {
        return "CompoundFactor{" + "leftExpression=" + leftExpression + ", rightExpression=" + rightExpression + '}';
    }
    private static DisjunctiveExpression disjunctiveCheck( DisjunctiveLexer lexer) throws ParserException{
            Optional<LocationalToken> token = lexer.nextValid();
            ParserException.verify(token);
            ParserException.verify(Token.Type.ID,token.get());
            return DisjunctiveExpression.Builder.build(token.get(), lexer);
    }
    private static void logicCheck(Optional<LocationalToken> token, Token.Type expectedType) throws ParserException{
        
        ParserException.verify(token);
        ParserException.verify(expectedType,token.get());
    }

    @Override
    public ConjunctiveRepresentation conjunctiveRepresentation() {
        return new ConjunctiveRepresentation("("+leftExpression.negate().conjunctiveRepresentation()+" or "+rightExpression.negate().conjunctiveRepresentation()+")", true);
    }
    public static final class Builder{
        public static final CompoundFactor build(LocationalToken token, DisjunctiveLexer lexer) throws ParserException{
            ParserException.verify(Token.Type.OPEN, token);
            //check for the id
            DisjunctiveExpression comp1 = disjunctiveCheck(lexer);
            logicCheck(lexer.nextValid(), Token.Type.AND);
            DisjunctiveExpression comp2 = disjunctiveCheck(lexer);
            logicCheck(lexer.nextValid(), Token.Type.CLOSE);
            
            return new CompoundFactor(comp1, comp2);
        }
    }
    
}
