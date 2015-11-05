/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessPiece;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nookie
 */
public class RookTest {
    
    public RookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validMove method, of class Rook.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        int xCoordinate = 1;
        int yCoordinate = 1;
        Rook instance = null;
        boolean expResult;
        boolean result;
        
        expResult = false;
        result = (new Rook(0,0,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(2,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Rook(1,0,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Rook(0,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Rook(2,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Rook(1,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(1,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(0,0,false)).validMove(-1, 0);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(0,0,false)).validMove(0, -1);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(7,7,false)).validMove(8, 7);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Rook(7,7,false)).validMove(7, 8);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Rook.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Rook.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
