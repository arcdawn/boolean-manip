/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Optional;
import java.lang.Error;
/**
 *
 * @author super
 */
public class ParserException extends Exception{


    private static final long serialVersionUID = 293;
    public enum ErrorCode{
        TOKEN_EXPECTED,
        INVALID_TOKEN,
        TRAILING_INPUT,
        AND_EXPECTED,
        OPEN_EXPECTED,
        CLOSE_EXPECTED,
        ID_EXPECTED;
        
    }
    private static ErrorCode errorCode;
    private final int location;
    //constructor
    ParserException(LocationalToken token, ErrorCode errorCode){
        this.errorCode = errorCode;
        this.location = token.getLocation();
    }
    ParserException(ErrorCode errorCode){
        this.errorCode = errorCode;
        this.location = -1;
    }
    //return error 
    public ErrorCode getErrorCode(){
        return this.errorCode;
    }
    //return error location
    public int getLocation(){
        return this.location;
    }

    @Override
    public  String toString() {
        return "ParserException{" + "serialVersionUID=" + serialVersionUID + ", errorCode=" + errorCode + ", location=" + location + '}';
    }
    //if there is no expected token
    public static void verify(Optional<LocationalToken> token) throws ParserException{
        if(!token.isPresent()){
            throw new ParserException(ErrorCode.TOKEN_EXPECTED);
        }
    }
    public final static void verify(Token.Type expectedType, LocationalToken token) throws ParserException{
        if(!expectedType.equals(token.getType())&& expectedType.errorCode.isPresent()){
            throw new ParserException(expectedType.errorCode.get());
        }
    }
    //if there is a trailing input
    public static void verifyEnd(Optional<LocationalToken> token) throws ParserException{
        if(token.isPresent()){
            throw new ParserException(ErrorCode.TRAILING_INPUT);
        }
    }
    
}
