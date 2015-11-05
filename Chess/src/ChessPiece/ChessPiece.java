package ChessPiece;

import ChessBoard.ChessBoard;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: ChessPiece
 * description: 
 *
 *
 */

public abstract class ChessPiece 
{
    private int xCoordinate;
    private int yCoordinate;
    private final boolean isWhite;
    private final PieceType pieceType;
    private boolean isAlive;
    
    public ChessPiece(int xCoordinate, int yCoordinate, boolean isWhite,
            PieceType pieceType)
    {
        if(ChessBoard.isValidSquare(xCoordinate,yCoordinate))
        {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            this.isWhite = isWhite;
            this.pieceType = pieceType;
            this.isAlive = true;
        }
        else
        {
            this.xCoordinate = -1;
            this.yCoordinate = -1;
            this.isWhite = isWhite;
            this.pieceType = pieceType;
            this.isAlive = false;
        }
    }
    
    public boolean getIsWhite()
    {
        return isWhite;
    }
    
    public boolean getIsAlive()
    {
        return isAlive;
    }
    
    public void setIsAlive(boolean isAlive)
    {
        this.isAlive = isAlive;
    }
    
    public PieceType getPieceType()
    {
        return pieceType;
    }
    
    public int getXCoordinate()
    {
        return xCoordinate;
    }
    
    public int getYCoordinate()
    {
        return yCoordinate;
    }
    
    public boolean moveTo(int xCoordinate, int yCoordinate)
    {
        if(validMove(xCoordinate,yCoordinate))
        {
            this.xCoordinate = xCoordinate;
            this.yCoordinate = yCoordinate;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean isSquareTakeable(int xCoordinate, int yCoordinate, 
            ChessBoard chessBoard)
    {
        return (chessBoard.hasWhitePiece(xCoordinate,yCoordinate) != isWhite);
    }
    
    public void removePiece(ChessBoard chessBoard)
    {
        chessBoard.setNoPiece(xCoordinate,yCoordinate);
        xCoordinate = -1;
        yCoordinate = -1;
        isAlive = false;
    }
    
    public abstract boolean validMove(int xCoordinate, int yCoordinate);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
    }

}
