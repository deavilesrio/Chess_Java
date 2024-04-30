package chessInterfaces;
import Types.LocationX;

/**
 * Interface defining the behavior of a bishop chess piece.
 * Implementing classes must provide functionality to move a bishop on the chessboard.
 * 
 * @author Diego Aviles
 * @version 1.0
 * @since 2024-04-20
 */
public interface intBishop {

    /**
     * Moves a bishop to the specified position on the chessboard.
     * 
     * @param toX The column coordinate (LocationX) to move the bishop to.
     * @param toY The row coordinate (int) to move the bishop to.
     * @return True if the move is valid for a bishop, false otherwise.
     */
    public boolean moveToBishop(LocationX toX, int toY);
}

