
package lexer;
import java.util.*;
import lexer.ParserException.ErrorCode;
/**
 *
 * @author super
 */
public final class Token {
    public enum Type{
        NOT("not", false, false, Optional.empty()), 
        AND("and", false, true,Optional.ofNullable(ErrorCode.AND_EXPECTED)), 
        OR("or", false, true,Optional.empty()), 
        OPEN("\\(", false, false, Optional.ofNullable(ErrorCode.OPEN_EXPECTED)), 
        CLOSE("\\)", false, false,Optional.ofNullable(ErrorCode.CLOSE_EXPECTED)), 
        ID("[a-z]+",true, false, Optional.ofNullable(ErrorCode.ID_EXPECTED)), 
        NUMBER("-?[0-9]+",true, false, Optional.empty()), 
        BINARYOP("\\+|-|/|\\*",true, false, Optional.empty()),
        WHITESPACE("\\S+", false, false,Optional.empty() );
        private final String typePattern;
        private final Boolean hasData;
        private boolean isComplex;
        Optional<ParserException.ErrorCode> errorCode;
        private Type(String typePattern, Boolean data, Boolean complexity, Optional<ParserException.ErrorCode> errorCode){
           this.typePattern = typePattern;
           //change this
           this.errorCode = errorCode;
           this.hasData = data;
           this.isComplex = complexity;
           
        }
        public String getStringPattern(){
            return typePattern;
        }
        public Boolean hasData(){
            return hasData;
        }
    }
    
    private final Type tokenType;
    private final Optional<String> data;
    //gets the type
    public Type getToken(){
        if(this.tokenType == null){
            return null;
        }
    return tokenType;
    }
    
    public Optional<String> getData(){
        return data;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (this.tokenType != other.tokenType) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.tokenType);
        return hash;
    }

    @Override
    public String toString() {
        return "Token{" + "tokenType=" + tokenType + ", data=" + data + '}';
    }
    
    
    
    //initialize map
    private static Map<Builder, Token> mapToken = new HashMap<>();
    
    //sets checks map if a Token exists
    //returns if exists; if not add to mapToken, then return;

    /**
     *
     * @param type
     * @param data
     * @return
     */
    public static Token of(Type type, String data){
        Builder build = new Builder(type, Optional.ofNullable(data));
        if(mapToken.containsKey(build)){
            return mapToken.get(build);
        }
        else{
            Token newToken = build.build();
            mapToken.put(build, newToken);
            return newToken;
        }
    }
    Token(Type type, Optional<String> data){
        this.tokenType = type;
        this.data = data;
    }
    
    private static class Builder{
        private final Type builderType;
        private final Optional<String> builderData; 
        Builder(Type type, Optional<String> data){
            this.builderData = data;
            this.builderType = type;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 67 * hash + Objects.hashCode(this.builderType);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Builder other = (Builder) obj;
            if (this.builderType != other.builderType) {
                return false;
            }
            if (!Objects.equals(this.builderData, other.builderData)) {
                return false;
            }
            return true;
        }
        
        private Token build(){
            return new Token(builderType, builderData);

        }
    }
    
}
