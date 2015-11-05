package ChessBoard;

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
    private int[] holdsPiece;
    private boolean isWhitePiece;
    
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
        return isWhitePiece;
    }
    
    public void setHasPiece(int[] holdsPiece, boolean isWhitePiece)
    {
        this.isWhitePiece = isWhitePiece;
        this.holdsPiece = holdsPiece;
    }
    
    public int[] getHeldPiece()
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
