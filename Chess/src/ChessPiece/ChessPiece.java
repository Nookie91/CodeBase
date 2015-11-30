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
    private boolean hasNotMoved;
    
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
            this.hasNotMoved = true;
        }
        else
        {
            this.xCoordinate = -1;
            this.yCoordinate = -1;
            this.isWhite = isWhite;
            this.pieceType = pieceType;
            this.isAlive = false;
            this.hasNotMoved = true;
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

    public boolean moveTo(int xCoordinate, int yCoordinate, ChessBoard chessBoard)
    {
        if (validMove(xCoordinate, yCoordinate, chessBoard))
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
        if (chessBoard.isSquareUnoccupied(xCoordinate, yCoordinate)) {
            return true;
        }
        return (chessBoard.hasWhitePiece(xCoordinate,yCoordinate) != isWhite);
    }
    
    public void removePiece(ChessBoard chessBoard)
    {
        chessBoard.setNoPiece(xCoordinate,yCoordinate);
        xCoordinate = -1;
        yCoordinate = -1;
        isAlive = false;
    }

    public boolean isLinearBlocked(int xCoordinate, int yCoordinate,
                                   ChessBoard chessBoard) {
        int deltaX, deltaY;
        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();

        if (deltaX == 0 && deltaY == 0) {
            return true;
        } else if (deltaX == 0) {
            if (deltaY > 0) {
                for (int i = getYCoordinate() + 1; i < yCoordinate; i++) {
                    if (!chessBoard.isSquareUnoccupied(xCoordinate, i)) {
                        return true;
                    }
                }
            } else {
                for (int i = getYCoordinate() - 1; i > yCoordinate; i--) {
                    if (!chessBoard.isSquareUnoccupied(xCoordinate, i)) {
                        return true;
                    }
                }
            }
        } else if (deltaY == 0) {
            if (deltaX > 0) {
                for (int i = getXCoordinate() + 1; i < xCoordinate; i++) {
                    if (!chessBoard.isSquareUnoccupied(i, yCoordinate)) {
                        return true;
                    }
                }
            } else {
                for (int i = getXCoordinate() - 1; i > xCoordinate; i--) {
                    if (!chessBoard.isSquareUnoccupied(i, yCoordinate)) {
                        return true;
                    }
                }
            }
        } else {
            return true;
        }

        return false;
    }

    public boolean isDiagonalBlocked(int xCoordinate, int yCoordinate,
                                     ChessBoard chessBoard) {
        int deltaX, deltaY;
        deltaX = xCoordinate - getXCoordinate();
        deltaY = yCoordinate - getYCoordinate();

        if (Math.abs(deltaX) != Math.abs(deltaY)) {
            return true;
        }

        if (deltaX == 0 && deltaY == 0) {
            return true;
        } else if (deltaX > 0) {
            if (deltaY > 0) {
                for (int i = 1; i < deltaY; i++) {
                    if (!chessBoard.isSquareUnoccupied(getXCoordinate() + i, getYCoordinate() + i)) {
                        return true;
                    }
                }
            } else {
                for (int i = -1; i > deltaY; i--) {
                    if (!chessBoard.isSquareUnoccupied(getXCoordinate() - i, getYCoordinate() + i)) {
                        return true;
                    }
                }
            }
        } else if (deltaY < 0) {
            if (deltaY > 0) {
                for (int i = 1; i < deltaY; i++) {
                    if (!chessBoard.isSquareUnoccupied(getXCoordinate() - i, getYCoordinate() + i)) {
                        return true;
                    }
                }
            } else {
                for (int i = -1; i > deltaY; i--) {
                    if (!chessBoard.isSquareUnoccupied(getXCoordinate() + i, getYCoordinate() + i)) {
                        return true;
                    }
                }
            }
        } else {
            return true;
        }

        return false;
    }

    public abstract boolean isMoveBlocked(int xCoordinate, int yCoordinate,
                                          ChessBoard chessBoard);

    public abstract boolean validMove(int xCoordinate, int yCoordinate,
                                      ChessBoard chessBoard);

    public boolean getHasNotMoved() {
        return hasNotMoved;
    }

    public void setHasMoved() {
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
