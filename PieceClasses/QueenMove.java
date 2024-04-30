package PieceClasses;
import Types.LocationX;
import Types.PieceType;
import chessInterfaces.intBishop;

/**
 * Represents the movement behavior of a Queen chess piece.
 * Combines the movement characteristics of a Rook and a Bishop.
 * Extends the RookMove class and implements the intBishop interface.
 * 
 * @author Devin Lara
 * @version 1.0
 * @since 2024-04-20
 */
public class QueenMove extends RookMove implements intBishop { //extend it to Rook

    /**
     * Constructor for creating a QueenMove object.
     * 
     * @param queen The type of Queen piece.
     * @param color The color of the Queen piece.
     * @param cur_posX The current X-coordinate position of the Queen.
     * @param cur_posY The current Y-coordinate position of the Queen.
     */
    public QueenMove(PieceType queen, String color, LocationX cur_posX, int cur_posY){
        super(queen, color, cur_posX, cur_posY );
    }

    /**
     * Overrides the moveTo method to implement Queen's movement rules.
     * A Queen can move horizontally, vertically, or diagonally.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a Queen, false otherwise.
     */

    @Override
    public boolean moveTo( LocationX new_posX, int new_posY){
       
            // Check if the new position satisfies either Rook's or Bishop's movement rules
            boolean RookMove = super.moveTo(new_posX, new_posY);

                // Valid move if either Rook's or Bishop's movement is valid
                if(RookMove || moveToBishop(new_posX, new_posY) ){
                  return true;
               }else{
                return false;
               }
            
    }

    /**
     * Implements the moveToBishop method defined in the intBishop interface.
     * Checks if the movement is valid for a Bishop.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a Bishop, false otherwise.
     */
    @Override
    public boolean moveToBishop(LocationX new_posX, int new_posY){
        // Check if the new position forms a diagonal movement
        if (Math.abs(new_posX.ordinal() - cur_x.ordinal()) == Math.abs( (8-new_posY) - (8 - cur_y)) ) {
            // Valid move if the new position forms a diagonal movement
            return true;

        }
        return false;
    }
}


