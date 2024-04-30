package PieceClasses;
import Types.LocationX;
import Types.PieceType;

/**
 * Represents the movement behavior of a Pawn chess piece.
 * Extends the Figure class.
 * 
 * @author Anthony Trancoso
 * @version 1.0
 * @since 2024-04-20
 */
public class PawnMove extends Figure{
    
    /**
     * Constructor for creating a PawnMove object.
     * 
     * @param pawn The type of Pawn piece.
     * @param color The color of the Pawn piece.
     * @param cur_posX The current X-coordinate position of the Pawn.
     * @param cur_posY The current Y-coordinate position of the Pawn.
     */
    public PawnMove(PieceType pawn, String color, LocationX cur_posX, int cur_posY){
        super(pawn, color, cur_posX, cur_posY);
    }
    
    /**
     * Overrides the moveTo method to implement Pawn's movement rules.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a Pawn, false otherwise.
     */
    @Override 
    public boolean moveTo(LocationX new_posX, int new_posY){
        System.out.println("Beggining: " + (8-cur_y));
        System.out.println((8-new_posY )+ " == " + (8-cur_y-1) + " && " + (new_posX.ordinal()) + " == " + (cur_x.ordinal()));
    
       
        // Check if the movement is valid based on the Pawn's color and position
        if(color.equals("White")){
            // White Pawn movement rules
            if(8-cur_y == 6){
                // Initial two-square advance for White Pawn
                if(((8-new_posY == 8-cur_y-1) && (new_posX.ordinal() == cur_x.ordinal())) || ((8-new_posY == 8-cur_y-2) && (new_posX.ordinal() == cur_x.ordinal()))){
                    return true;
                }
                
            }else{
                // Regular one-square advance for White Pawn
                if(8-new_posY == 8-cur_y-1 && new_posX.ordinal() == cur_x.ordinal()){
                    return true;
                }
            }
        }else if(color.equals("Black")){
            // Black Pawn movement rules
            if(8-cur_y == 1){
                // Initial two-square advance for Black Pawn
                if((8-new_posY == 8-cur_y+1 && new_posX.ordinal() == cur_x.ordinal()) || (8-new_posY == 8-cur_y+2 && new_posX.ordinal() == cur_x.ordinal())){
                    return true;
                }
            }else{
                // Regular one-square advance for Black Pawn
                if(8-new_posY == 8-cur_y+1 && new_posX.ordinal() == cur_x.ordinal()){
                    return true;
                }
            }
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

