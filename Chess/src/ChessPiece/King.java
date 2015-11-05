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
    private boolean hasNotMoved;
    public King(int xCoordinate, int yCoordinate, boolean isWhite)
    {
        super(xCoordinate, yCoordinate, isWhite, PieceType.KING);
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
        return ((Math.abs(deltaX) < 2) && (Math.abs(deltaY) < 2));
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
