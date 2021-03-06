package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: Bishop
 * description: 
 *
 *
 */

public class Bishop extends ChessPiece
{
    public Bishop(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.BISHOP);
    }

    @Override
    public boolean isMoveBlocked(int xCoordinate, int yCoordinate, ChessBoard chessBoard) {
        return isDiagonalBlocked(xCoordinate, yCoordinate, chessBoard);
    }

    @Override
    public boolean validMove(int xCoordinate, int yCoordinate, ChessBoard chessBoard)
    {
        int deltaX, deltaY;
        if (!ChessBoard.isValidSquare(xCoordinate, yCoordinate)) {
            return false;
        }
        if (!isSquareTakeable(xCoordinate, yCoordinate, chessBoard))
        {
            return false;
        }
        
        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();
        
        return Math.abs(deltaX) == Math.abs(deltaY);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        
    }

}
