/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexer;

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
public class CompoundFactorTest {
    
    public CompoundFactorTest() {
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
     * Test of toString method, of class CompoundFactor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CompoundFactor instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjunctiveRepresentation method, of class CompoundFactor.
     */
    @Test
    public void testConjunctiveRepresentation() {
        System.out.println("conjunctiveRepresentation");
        CompoundFactor instance = null;
        ConjunctiveRepresentation expResult = null;
        ConjunctiveRepresentation result = instance.conjunctiveRepresentation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
