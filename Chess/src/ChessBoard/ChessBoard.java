package ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessBoard;
 * class: ChessBoard
 * description: 
 *
 *
 */

public class ChessBoard 
{
    private static final int BOARDLENGTH = 8;
    private static final int BOARDWIDTH = 8;
    private final ChessSquare[][] chessBoard = 
            new ChessSquare[BOARDWIDTH][BOARDLENGTH];
    
    public ChessBoard()
    {
        for(int i = 0; i < BOARDWIDTH; i ++)
        {
            for(int j = 0; j < BOARDLENGTH; j ++)
            {
                chessBoard[i][j] = new ChessSquare(i,j);
            }
        }
    }
    
    public static boolean isValidSquare(int xCoordinate, int yCoordinate)
    {
        return xCoordinate >= 0 && xCoordinate < BOARDWIDTH &&
               yCoordinate >= 0 && yCoordinate < BOARDLENGTH ;
    }    

    public boolean isSquareUnoccupied(int xCoordinate, int yCoordinate)
    {
        return chessBoard[xCoordinate][yCoordinate].getIsUnoccupied();
    }
    
    public void setHasPiece(int xCoordinate, int yCoordinate, int[] holdsPiece, boolean isWhitePiece)
    {
        chessBoard[xCoordinate][yCoordinate].setHasPiece(holdsPiece, isWhitePiece);
    }
    
    public int[] getHeldPiece(int xCoordinate, int yCoordinate)
    {
        return chessBoard[xCoordinate][yCoordinate].getHeldPiece();
    }
       
    public boolean hasWhitePiece(int xCoordinate, int yCoordinate)
    {
        return chessBoard[xCoordinate][yCoordinate].getHasWhitePiece();
    }
    
    public void setNoPiece(int xCoordinate, int yCoordinate)
    {
        chessBoard[xCoordinate][yCoordinate].setNoPiece();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
