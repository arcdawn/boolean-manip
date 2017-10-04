/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lexer.ParserException.ErrorCode;
import static lexer.Token.Type;


/**
 *
 * @author super
 */
public class Lexer {
    private static Pattern tokenPatterns;
    private static boolean hasNextToken;
    private final Matcher matcher;
    
    static{
        StringBuilder tokenValues = new StringBuilder();
        for(Token.Type tokenType: Token.Type.values()){
            tokenValues.append("|").append(tokenType.getStringPattern());
        }
        String tokenString = tokenValues.toString();
        tokenString.substring(1);
        tokenPatterns = Pattern.compile(tokenString);
    }
    public Lexer(String input){
        //token definition
        //compile these in one string
        matcher = tokenPatterns.matcher(input);
        
        //format("| %s", string
    }
    //returns if there is a next token
    public Boolean hasNext(){
        return matcher.find();
    }
    //returns next LocationalToken
    public LocationalToken next() throws ParserException{

        for(Token.Type type: Token.Type.values()){
            if(Pattern.matches(type.getStringPattern(), matcher.group())){
                Token locToken = Token.of(type, matcher.group());
                return new LocationalToken(locToken, matcher.start());
            }
        }
           
        throw new ParserException(ErrorCode.TOKEN_EXPECTED);
    }
    
    //Next valid token if applicable
    public Optional<LocationalToken> nextValid(Set<Token.Type> validTypes,
            Set<Token.Type> invalidTypes) throws ParserException{
        while(hasNext()){
            LocationalToken Token = next();
            if(validTypes.contains(Token.getType())){
                return Optional.of(Token);
            }
            if(invalidTypes.contains(Token.getType())){
                throw new ParserException(Token, ErrorCode.INVALID_TOKEN);
            }
        
        }
        return Optional.empty();
        
    }
    
}
