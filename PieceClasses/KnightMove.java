package PieceClasses;

import Types.LocationX;
import Types.PieceType;

/**
 * Represents the movement behavior of a Knight chess piece.
 * Extends the Figure class.
 * 
 * @author Devin Lara
 * @version 1.0
 * @since 2024-04-20
 */
public class KnightMove extends Figure{ //extend it to Queen

    /**
     * Constructor for creating a KnightMove object.
     * 
     * @param knight The type of Knight piece.
     * @param color The color of the Knight piece.
     * @param cur_x The current X-coordinate position of the Knight.
     * @param cur_y The current Y-coordinate position of the Knight.
     */
    public KnightMove(PieceType knight, String color, LocationX cur_x, int cur_y){
        super(knight, color, cur_x, cur_y);
    }

    /**
     * Overrides the moveTo method to implement Knight's movement rules.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a Knight, false otherwise.
     */
    
    public boolean moveTo(LocationX new_posX, int new_posY){ //checks if movement is valid
        LocationX new_x = LocationX.valueOf(new_posX +"");
        // Check if the movement is valid for a Knight
        if (Math.abs((new_x.ordinal()) - (cur_x.ordinal())) == 2 && Math.abs((8 - new_posY) - (8- cur_y)) == 1 ) {
            // Valid move if the new position is within the board and not occupied    
            return true;

        }else if( Math.abs((8 - new_x.ordinal()) - (8-cur_x.ordinal())) == 1 && Math.abs(new_posY - cur_y) == 2 ){
            return true;
        }
        return false;
        
    }

    /**
     * Overrides the toString method to provide a custom string representation.
     * 
     * @return An empty string.
     */
    public String toString(){
        return "";
    }


   

   

   
}