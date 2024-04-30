package PieceClasses;
import Types.LocationX;
import Types.PieceType;

/**
 * Represents the movement behavior of a Rook chess piece.
 * Extends the Figure class.
 * 
 * @author Diego Aviles
 * @version 1.0
 * @since 2024-04-20
 */
public class RookMove extends Figure{

    /**
     * Constructor for creating a RookMove object.
     * 
     * @param rook The type of Rook piece.
     * @param color The color of the Rook piece.
     * @param cur_posX The current X-coordinate position of the Rook.
     * @param cur_posY The current Y-coordinate position of the Rook.
     */


    public RookMove(PieceType rook, String color, LocationX cur_posX, int cur_posY){
        super(rook, color, cur_posX, cur_posY);
    }

    /**
     * Overrides the moveTo method to implement Rook's movement rules.
     * A Rook can move vertically or horizontally.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a Rook, false otherwise.
     */


       @Override
       public boolean moveTo( LocationX new_posX, int new_posY){
            // Check if the new position is along the same column or row

            if(new_posX.ordinal() == cur_x.ordinal() || cur_y == new_posY){
                return true; //valid movement
            }else{
                return false; //invalid movement
            }

        }
        
        /**
        * Returns a string representation of the RookMove object.
        * 
        * @return An empty string representation.
        */
        public String toString(){
            return ""; //empty string
        }
    
}


