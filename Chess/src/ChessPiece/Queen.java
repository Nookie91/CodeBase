package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: Queen
 * description: 
 *
 *
 */

public class Queen extends ChessPiece
{
    public Queen(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.QUEEN);
    }

    @Override
    public boolean isMoveBlocked(int xCoordinate, int yCoordinate, ChessBoard chessBoard) {
        return isLinearBlocked(xCoordinate, yCoordinate, chessBoard) &&
                isDiagonalBlocked(xCoordinate, yCoordinate, chessBoard);
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
        
        return !((!(Math.abs(deltaX) == Math.abs(deltaY)) &&
                (deltaX != 0 && deltaY != 0)) || 
                (deltaX == 0 && deltaY == 0));
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
