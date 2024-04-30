package chessInterfaces;
import Types.LocationX;

/**
 * Interface defining the behavior of a chessboard.
 * Implementing classes must provide functionality to verify coordinates on the chessboard.
 * 
 * @author Devin Lara
 * @version 1.0
 * @since 2024-04-20
 */
public interface IntChessBoard {

    /**
     * Verifies whether the given row and column coordinates are valid on the chessboard.
     * 
     * @param row The row coordinate (LocationX) to verify.
     * @param col The column coordinate (int) to verify.
     * @return True if the coordinates are within the bounds of the chessboard, false otherwise.
     */
    public boolean verifyCoordinate(LocationX row, int col);
}


