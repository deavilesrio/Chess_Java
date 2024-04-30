package PieceClasses;
import Types.LocationX;
import chessInterfaces.IntChessBoard;

/**
 * Class representing a chess board.
 * Implements the IntChessBoard interface.
 * This class provides functionality to verify coordinates on the chess board.
 * 
 * @author Anthony Trancoso
 * @author Devin Lara
 * @version 1.0
 * @since 2024-04-20
 */
public class ChessBoard implements IntChessBoard {

    /**
     * Verifies if the given coordinate is valid on the chess board.
     * 
     * @param row The row coordinate (LocationX) to verify.
     * @param col The column coordinate to verify.
     * @return True if the coordinate is within the bounds of the chess board, false otherwise.
     */
    public boolean verifyCoordinate(LocationX row, int col){
        
        return row.ordinal() >= 0 && row.ordinal() < 8 && col >= 0 && col < 8;
    }
    
}


