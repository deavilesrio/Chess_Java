package PieceClasses;
import Types.LocationX;
import Types.PieceType;
import chessInterfaces.intFigure;


/**
 * Abstract class representing a generic chess piece.
 * Implements the intFigure interface.
 * 
 * @author Anthony Trancoso
 * @author Devin Lara
 * @author Diego Aviles
 * @version 1.0
 * @since 2024-04-20
 */

public abstract class Figure implements intFigure{
//Fields
   public PieceType name; // The type of the chess piece
   public String color; // The color of the chess piece
   public LocationX cur_x; // The current X-coordinate position of the chess piece
   public int cur_y; // The current Y-coordinate position of the chess piece


    /**
     * Constructor for creating a Figure object.
     * 
     * @param name The type of the chess piece.
     * @param color The color of the chess piece.
     * @param cur_x The current X-coordinate position of the chess piece.
     * @param cur_y The current Y-coordinate position of the chess piece.
     */
    Figure(PieceType name, String color, LocationX cur_x, int cur_y){ //Constructor
        this.name = name;
        this.color = color;
        this.cur_x = cur_x;
        this.cur_y = cur_y;

    }

    /**
     * Abstract method to determine if a chess piece can move to a specified position.
     * 
     * @param toX The X-coordinate position to move to.
     * @param toY The Y-coordinate position to move to.
     * @return True if the move is valid, false otherwise.
     */

    public abstract boolean moveTo(LocationX toX, int toY);

    /**
     * Abstract method to return a string representation of the chess piece.
     * 
     * @return A string representation of the chess piece.
     */
    public abstract String toString();
}






