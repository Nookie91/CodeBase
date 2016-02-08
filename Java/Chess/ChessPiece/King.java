package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: King
 * description: 
 *
 *
 */

public class King extends ChessPiece
{

    public King(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.KING);
    }

    @Override
    public boolean isMoveBlocked(int xCoordinate, int yCoordinate, ChessBoard chessBoard) {
        return false;
    }

    @Override
    public boolean validMove(int xCoordinate, int yCoordinate, ChessBoard chessBoard)
    {
        int deltaX, deltaY;
        if(!ChessBoard.isValidSquare(xCoordinate, yCoordinate))
        {
            return false;
        }
        if (!isSquareTakeable(xCoordinate, yCoordinate, chessBoard)) {
            return false;
        }
        
        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();
        return ((Math.abs(deltaX) < 2) && (Math.abs(deltaY) < 2));
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
