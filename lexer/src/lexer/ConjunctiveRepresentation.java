
package lexer;

/**
 *
 * @author super
 */
public class ConjunctiveRepresentation {
    private final String representation;
    private final boolean negation;
    public ConjunctiveRepresentation(String rep, boolean neg){
        representation = rep;
        negation = neg;
    }
    public String representationGetter(){
        return representation;
    }
    public Boolean negationGetter(){
        return negation;
    }
    
}
