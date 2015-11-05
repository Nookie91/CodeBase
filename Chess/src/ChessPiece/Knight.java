package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: Knight
 * description: 
 *
 *
 */

public class Knight extends ChessPiece
{
    public Knight(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.KNIGHT);
    }

    @Override
    public boolean validMove(int xCoordinate, int yCoordinate)
    {
        int deltaX, deltaY;
        if(!ChessBoard.isValidSquare(xCoordinate, yCoordinate))
        {
            return false;
        }
        
        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();
        
        return (Math.abs(deltaX) == 1 && Math.abs(deltaY) == 2) ||
                (Math.abs(deltaX) == 2 && Math.abs(deltaY) == 1);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
