package ChessPiece;

/**
 * author: Nicholas James Cook
 * package ChessPiece;
 * class: PieceType
 * description: 
 *
 *
 */

public enum PieceType
{    
    KING(0,1),
    QUEEN(1,1),
    BISHOP(2,2),
    KNIGHT(3,2),
    ROOK(4,2),
    PAWN(5,8);
    
    private final int numberOfPieces;
    private final int[][] startingPosition;
    private final int ordinal;

    private final int[][][] positions  = {{{4,0}},
                                {{5,0}},
                                {{2,0},{5,0}},
                                {{1,0},{6,0}},
                                {{0,0},{7,0}},
                                {{0,1},{1,1},{2,1},{3,1},{4,1},{5,1},{6,1},{7,1}}};
    
    PieceType(int ordinal, int numberOfPieces)
    {
        this.ordinal = ordinal;
        this.numberOfPieces = numberOfPieces;
        this.startingPosition = positions[ordinal];
    }
    
    public int getNumberOfPieces()
    {
        return numberOfPieces;
    }
    
    public int[][] getStartingPosition()
    {
        return startingPosition;
    }
    
    public int getOrdinal()
    {
        return ordinal;
    }
}