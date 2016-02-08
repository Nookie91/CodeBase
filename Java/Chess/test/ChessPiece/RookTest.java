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
        
        Integer[][] move = {{0,0,1,1},
                        {2,2,1,1},
                        {1,0,1,1},
                        {0,1,1,1},
                        {2,1,1,1},
                        {1,2,1,1},
                        {1,1,1,1},
                        {0,0,-1,0},
                        {0,0,0,-1},
                        {7,7,8,7},
                        {7,7,7,8}};
        
        Boolean[] pieceColor = {false,
                               false,
                               false,
                               false,
                               false,
                               false,
                               false,
                               false,
                               false,
                               false,
                               false};
        
        Boolean[] expResult = {false,
                               false,
                               true,
                               true,
                               true,
                               true,
                               false,
                               false,
                               false,
                               false,
                               false};
        
        Rook instance = null;
        boolean result;
        
        for(int i = 0; i < expResult.length; i ++)
        {
            result = (new Rook(move[i][0],move[i][1],pieceColor[i])).validMove(move[i][2],move[i][3]);
            assertEquals(expResult[i],result);
        }
        
        
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
