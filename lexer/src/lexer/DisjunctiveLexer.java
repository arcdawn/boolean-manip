package lexer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author super
 */
public final class DisjunctiveLexer {
    public static final Set<Token.Type> validTokenSet = new HashSet<Token.Type>();
    public static final Set<Token.Type> invalidTokenSet = new HashSet<Token.Type>();
    private Lexer lexer;
    static{
        Token.Type[] tokenArrayValid = {Token.Type.AND, Token.Type.ID, Token.Type.NOT, Token.Type.OPEN, Token.Type.CLOSE};
        Token.Type[] tokenArrayInvalid = {Token.Type.OR, Token.Type.NUMBER, Token.Type.BINARYOP};
        validTokenSet.addAll(Arrays.asList(tokenArrayValid));
        validTokenSet.addAll(Arrays.asList(tokenArrayInvalid));
        
    }
    DisjunctiveLexer(String input){
        lexer = new Lexer(input);
    }
    public Optional<LocationalToken> nextValid() throws ParserException{
        return lexer.nextValid(validTokenSet, invalidTokenSet);
    }
}
