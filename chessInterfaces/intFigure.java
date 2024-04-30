package chessInterfaces;
import Types.LocationX;
/**
 * Interface defining the behavior of a chess figure.
 * Implementing classes must provide functionality for moving the figure on the chessboard.
 * 
 * @author Anthony Trancoso
 * @version 1.0
 * @since 2024-04-20
 */

public interface intFigure {
    /**
     * Moves the chess figure to the specified position on the chessboard.
     * 
     * @param toX The new X position to move to (LocationX).
     * @param toY The new Y position to move to (int).
     * @return True if the move is valid for the figure, false otherwise.
     */
    public boolean moveTo(LocationX toX, int toY);
}


