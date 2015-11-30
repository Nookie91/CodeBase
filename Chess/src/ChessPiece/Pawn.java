package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: Pawn
 * description: 
 *
 *
 */

public class Pawn extends ChessPiece
{
    public Pawn(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.PAWN);
    }

    @Override
    public boolean isMoveBlocked(int xCoordinate, int yCoordinate, ChessBoard chessBoard) {
        return isLinearBlocked(xCoordinate, yCoordinate, chessBoard);
    }

    @Override
    public boolean validMove(int xCoordinate, int yCoordinate, ChessBoard chessBoard)
    {
        int deltaX, deltaY;
        if(!ChessBoard.isValidSquare(xCoordinate, yCoordinate))
        {
            return false;
        }

        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();
        if ((deltaX != 0 && (!isSquareTakeable(xCoordinate, yCoordinate, chessBoard) ||
                chessBoard.isSquareUnoccupied(xCoordinate, yCoordinate) == true)) ||
                (deltaX == 0 && chessBoard.isSquareUnoccupied(xCoordinate, yCoordinate) == false)) {
            return false;
        }
        if(getIsWhite())
        {
            return (((deltaX == 0) && (deltaY == 2) && getHasNotMoved()) ||
                    ((Math.abs(deltaX) < 2) && (deltaY == 1)));
        }
        else
        {
            return (((deltaX == 0) && (deltaY == -2) && getHasNotMoved()) ||
                    ((Math.abs(deltaX) < 2) && (deltaY == -1)));
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
