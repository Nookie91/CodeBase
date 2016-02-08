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
public class QueenTest {
    
    public QueenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of validMove method, of class Queen.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        int xCoordinate = 1;
        int yCoordinate = 1;
        Queen instance = null;
        boolean expResult;
        boolean result;
        
        expResult = true;
        result = (new Queen(0,0,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(0,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(0,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(1,0,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(1,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(2,0,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(2,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = true;
        result = (new Queen(2,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Queen(1,1,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        
        expResult = false;
        result = (new Queen(3,2,false)).validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Queen.
     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Queen.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
