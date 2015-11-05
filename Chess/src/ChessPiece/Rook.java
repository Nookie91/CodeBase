package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: Rook
 * description: 
 *
 *
 */

public class Rook extends ChessPiece
{
    private boolean hasNotMoved;
    public Rook(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.ROOK);
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
        return !((deltaX != 0 && deltaY != 0) || (deltaX == 0 && deltaY == 0));
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
