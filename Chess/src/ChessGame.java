
import ChessBoard.*;
import ChessPiece.*;
//import ChessPiece.PieceType;


/**
 * author: Nicholas James Cook
 * class: ChessGame
 * description: 
 *
 *
 */

public class ChessGame 
{
    private final static int NUMBEROFPLAYERS = 2;
    private final static int WHITEPLAYER = 0;
    private final static int BLACKPLAYER = 1;
    private final static int PIECESPERPLAYER = 16;
    
    public final ChessPiece[][] pieces;
    private final ChessBoard board;        
            
    public ChessGame()
    {
        pieces = new ChessPiece[NUMBEROFPLAYERS][PIECESPERPLAYER];
        board = new ChessBoard();
                
        for(int player = 0; player < NUMBEROFPLAYERS; player ++)
        {
            int index = 0;
            for(PieceType i:PieceType.values())
            {
                for(int[] j: i.getStartingPosition())
                {
                    if(player == WHITEPLAYER)
                    {
                        pieces[player][index] = createPiece(j[0],j[1],
                                i,true);
                        board.setHasPiece(j[0],j[1],pieces[player][index]);
                    }
                    else
                    {
                        pieces[player][index] = createPiece(j[0],8-j[1],
                                i,false);
                        board.setHasPiece(j[0],8-j[1],pieces[player][index]);
                    }
                    index ++;
                }
                
            }
        }
        
    }

    private ChessPiece createPiece(int xCoordinate, 
                             int yCoordinate, PieceType pieceType, 
                             boolean isWhite)
    {
        ChessPiece piece = null;
        switch(pieceType)
                {
                    case KING:
                        piece = new King(xCoordinate,yCoordinate,isWhite);   
                        break;
                    case QUEEN:
                        piece = new Queen(xCoordinate,yCoordinate,isWhite);
                        break;
                    case BISHOP:
                        piece = new Bishop(xCoordinate,yCoordinate,isWhite);
                        break;
                    case KNIGHT:
                        piece = new Knight(xCoordinate,yCoordinate,isWhite);
                        break;
                    case ROOK:
                        piece = new Rook(xCoordinate,yCoordinate,isWhite);
                        break;
                    case PAWN:
                        piece = new Pawn(xCoordinate,yCoordinate,isWhite);
                        break;      
                }

        return piece;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        ChessGame game = new ChessGame();
        for(ChessPiece[] i : game.pieces)
        {
            for(ChessPiece j : i)
            {
                System.out.println(j.getPieceType());
            }
        }
        
        // TODO code application logic here
    }

}
