/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Optional;
import lexer.Token.Type;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author super
 */
public class DisjunctiveExpressionTest {
    
    public DisjunctiveExpressionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of negate method, of class DisjunctiveExpression.
     */
    @Test
    public void testNegate() throws ParserException {
        System.out.println("negate");
        Optional<String> test = Optional.ofNullable("asdf");
        Token tok = new Token(Type.ID, test);
        LocationalToken token = new LocationalToken(tok, 1);
        Identifier id = Identifier.Builder.build(token);
        DisjunctiveExpression instance = new DisjunctiveExpression(false, id);
        boolean expResult = true;
        DisjunctiveExpression result = instance.negate();
        assertEquals(expResult, result.getPositive());
    }

    /**
     * Test of getPositive method, of class DisjunctiveExpression.
     */
    @Test
    public void testGetPositive() throws ParserException {
        System.out.println("getPositive");
        Optional<String> test = Optional.ofNullable("asdf");
        Token tok = new Token(Type.ID, test);
        LocationalToken token = new LocationalToken(tok, 1);
        Identifier id = Identifier.Builder.build(token);
        DisjunctiveExpression instance = new DisjunctiveExpression(false, id);
        boolean expResult = false;
        boolean result = instance.getPositive();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of conjunctiveRepresentation method, of class DisjunctiveExpression.
     */
    @Test
    public void testConjunctiveRepresentation() {
        System.out.println("conjunctiveRepresentation");
        DisjunctiveExpression instance = null;
        String expResult = "";
        String result = instance.conjunctiveRepresentation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
