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
    private boolean hasNotMoved;
    public Pawn(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.PAWN);
        hasNotMoved = true;
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
    
    public boolean getHasNotMoved()
    {
        return hasNotMoved;
    }
    
    public void setHasMoved()
    {
        hasNotMoved = false;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
