/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Optional;
import lexer.Token.Type;

/**
 *
 * @author super
 */
public class LocationalToken {
    private final Token token;
    private final int location;
    public LocationalToken(Token token, int location){
        this.token = token;
        this.location = location;
    }
    public Token getToken(){
        return token;
    }
    public int getLocation(){
        return location;
    }
    public Type getType(){
        return this.token.getToken();
    }
    public Optional<String> hasData(){
        return this.token.getData();
    }
    
}
