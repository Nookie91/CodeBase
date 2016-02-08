package ChessBoard;

import ChessPiece.*;

/**
 * author: Nicholas James Cook
 * package ChessBoard;
 * class: ChessSquare
 * description: 
 *
 *
 */

public class ChessSquare 
{
    public final int xCoordinate;
    public final int yCoordinate;
    public final boolean isBlack;
    private ChessPiece holdsPiece;
    
    public ChessSquare(int xCoordinate, int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.holdsPiece = null;
        this.isBlack = ((xCoordinate % 2) == (yCoordinate % 2));
    }
    
    public boolean getIsUnoccupied()
    {
        return (holdsPiece == null);
    }
          
    public boolean getHasWhitePiece()
    {
        return holdsPiece.getIsWhite();
    }
    
    public void setHasPiece(ChessPiece holdsPiece)
    {   
        this.holdsPiece = holdsPiece;
    }
    
    public ChessPiece getHeldPiece()
    {
        return holdsPiece;
    }
    
    public void setNoPiece()
    {
        holdsPiece = null;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
