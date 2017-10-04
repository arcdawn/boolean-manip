
package lexer;

import lexer.ParserException.ErrorCode;

/**
 *
 * @author super
 */
public final class Identifier implements Factor {
    private final String id;
    private Identifier(String input){
        id = input;
    }
    public String getID(){
        return id;
    }
    @Override
    public String toString() {
        return "Identifier{" + "id=" + id + '}';
    }

    @Override
    public ConjunctiveRepresentation conjunctiveRepresentation() {
        return new ConjunctiveRepresentation(this.id, false);
    }
    
    public static final class Builder{
        public static final Identifier build(LocationalToken token) throws ParserException{
            //verify with ParserException
            if(token.getType().equals(Token.Type.ID)){
                return new Identifier(token.hasData().get());
            }
            throw new ParserException(ErrorCode.ID_EXPECTED);
        }
}
    
}
