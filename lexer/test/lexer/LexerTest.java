/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

import java.util.Optional;
import java.util.Set;
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
public class LexerTest {
    
    public LexerTest() {
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
     * Test of hasNext method, of class Lexer.
     */
    @Test
    public void testHasNext() {
        System.out.println("hasNext");
        Lexer instance = null;
        Boolean expResult = null;
        Boolean result = instance.hasNext();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of next method, of class Lexer.
     */
    @Test
    public void testNext() throws Exception {
        System.out.println("next");
        Lexer instance = null;
        LocationalToken expResult = null;
        LocationalToken result = instance.next();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nextValid method, of class Lexer.
     */
    @Test
    public void testNextValid() throws Exception {
        System.out.println("nextValid");
        Set<Token.Type> validTypes = null;
        Set<Token.Type> invalidTypes = null;
        Lexer instance = null;
        Optional<LocationalToken> expResult = null;
        Optional<LocationalToken> result = instance.nextValid(validTypes, invalidTypes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
