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
public class ConjunctiveRepresentationTest {
    
    public ConjunctiveRepresentationTest() {
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
     * Test of representationGetter method, of class ConjunctiveRepresentation.
     */
    @Test
    public void testRepresentationGetter() {
        System.out.println("representationGetter");
        ConjunctiveRepresentation instance = new ConjunctiveRepresentation("a and b", false);
        String expResult = "a and b";
        String result = instance.representationGetter();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of negationGetter method, of class ConjunctiveRepresentation.
     */
    @Test
    public void testNegationGetter() {
        System.out.println("negationGetter");
        ConjunctiveRepresentation instance = new ConjunctiveRepresentation("a and b", false);
        Boolean expResult = false;
        Boolean result = instance.negationGetter();
        assertEquals(expResult, result);
        
    }
    
}
