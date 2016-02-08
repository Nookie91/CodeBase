/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChessPiece;

import ChessBoard.ChessBoard;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nookie
 */
public class ChessPieceTest {
    
    public ChessPieceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getIsWhite method, of class ChessPiece.
     */
    @Test
    public void testGetIsWhite() {
        System.out.println("getIsWhite");
        ChessPiece instance = null;
        boolean expResult = false;
        boolean result = instance.getIsWhite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsAlive method, of class ChessPiece.
     */
    @Test
    public void testGetIsAlive() {
        System.out.println("getIsAlive");
        ChessPiece instance = null;
        boolean expResult = false;
        boolean result = instance.getIsAlive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsAlive method, of class ChessPiece.
     */
    @Test
    public void testSetIsAlive() {
        System.out.println("setIsAlive");
        boolean isAlive = false;
        ChessPiece instance = null;
        instance.setIsAlive(isAlive);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPieceType method, of class ChessPiece.
     */
    @Test
    public void testGetPieceType() {
        System.out.println("getPieceType");
        ChessPiece instance = null;
        PieceType expResult = null;
        PieceType result = instance.getPieceType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXCoordinate method, of class ChessPiece.
     */
    @Test
    public void testGetXCoordinate() {
        System.out.println("getXCoordinate");
        ChessPiece instance = null;
        int expResult = 0;
        int result = instance.getXCoordinate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYCoordinate method, of class ChessPiece.
     */
    @Test
    public void testGetYCoordinate() {
        System.out.println("getYCoordinate");
        ChessPiece instance = null;
        int expResult = 0;
        int result = instance.getYCoordinate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveTo method, of class ChessPiece.
     */
    @Test
    public void testMoveTo() {
        System.out.println("moveTo");
        int xCoordinate = 0;
        int yCoordinate = 0;
        ChessPiece instance = null;
        boolean expResult = false;
        boolean result = instance.moveTo(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSquareTakeable method, of class ChessPiece.
     */
    @Test
    public void testIsSquareTakeable() {
        System.out.println("isSquareTakeable");
        int xCoordinate = 0;
        int yCoordinate = 0;
        ChessBoard chessBoard = null;
        ChessPiece instance = null;
        boolean expResult = false;
        boolean result = instance.isSquareTakeable(xCoordinate, yCoordinate, chessBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePiece method, of class ChessPiece.
     */
    @Test
    public void testRemovePiece() {
        System.out.println("removePiece");
        ChessBoard chessBoard = null;
        ChessPiece instance = null;
        instance.removePiece(chessBoard);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validMove method, of class ChessPiece.
     */
    @Test
    public void testValidMove() {
        System.out.println("validMove");
        int xCoordinate = 0;
        int yCoordinate = 0;
        ChessPiece instance = null;
        boolean expResult = false;
        boolean result = instance.validMove(xCoordinate, yCoordinate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ChessPiece.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ChessPiece.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ChessPieceImpl extends ChessPiece {

        public ChessPieceImpl() {
            super(0, 0, false, null);
        }

        public boolean validMove(int xCoordinate, int yCoordinate) {
            return false;
        }
    }
    
}
