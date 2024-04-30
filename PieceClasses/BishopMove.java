package PieceClasses;
import Types.LocationX;
import Types.PieceType;

/**
 * Class representing the movement behavior of a bishop chess piece.
 * Extends the Figure class.
 * 
 * @author Diego Aviles
 * @version 1.0
 * @since 2024-04-20
 */

public class BishopMove extends Figure {
    /**
     * Constructor for creating a bishop chess piece with the specified attributes.
     * 
     * @param bishop The type of the bishop piece (PieceType).
     * @param color The color of the bishop piece (String).
     * @param cur_posX The current X position of the bishop on the board (LocationX).
     * @param cur_posY The current Y position of the bishop on the board (int).
     */
    public PieceType name;
    public String color;
    public LocationX cur_x;
    public int cur_y;
    public BishopMove(PieceType Bishop, String color, LocationX cur_posX, int cur_posY){
        super(Bishop, color, cur_posX, cur_posY);//King subclass inherits behaviors of superclass   
        this.cur_x = cur_posX;                                                                                     
    }

    /**
     * Checks if the bishop chess piece can move to the specified position.
     * 
     * @param new_x The new X position to move to (LocationX).
     * @param new_posY The new Y position to move to (int).
     * @return True if the move is valid for the bishop piece, false otherwise.
     */
    @Override
    public boolean moveTo( LocationX new_x, int new_posY){
        if (Math.abs(new_x.ordinal() - cur_x.ordinal()) == Math.abs( (8-new_posY) - (7 - cur_y))) {
            // Valid move if the new position is within the board and not occupied
            return true;
        }
        return false;
        
    }
    /**
     * Provides a string representation of the bishop chess piece.
     * 
     * @return An empty string representation.
     */
    public String toString(){
        return "";
    }

}

