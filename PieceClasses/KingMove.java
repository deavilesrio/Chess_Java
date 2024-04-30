package PieceClasses;

import Types.LocationX;
import Types.PieceType;

/**
 * Represents the movement behavior of a King chess piece.
 * Extends the QueenMove class.
 * 
 * @author Anthony Trancoso
 * @version 1.0
 * @since 2024-04-20
 */
public class KingMove extends QueenMove{ //King is extended from Queen
    

    /**
     * Constructor for creating a KingMove object.
     * 
     * @param king The type of King piece.
     * @param color The color of the King piece.
     * @param cur_posX The current X-coordinate position of the King.
     * @param cur_posY The current Y-coordinate position of the King.
     */
    public KingMove(PieceType king, String color, LocationX cur_posX, int cur_posY){
        super(king, color, cur_posX, cur_posY); //King subclass inherits behaviors of superclass                                                                                                     Queen
    }
    
    /**
     * Overrides the moveTo method to implement King's movement rules.
     * 
     * @param new_posX The new X-coordinate position.
     * @param new_posY The new Y-coordinate position.
     * @return True if the movement is valid for a King, false otherwise.
     */
    @Override 
    public boolean moveTo( LocationX new_posX, int  new_posY){
        
        // Check if the move is valid from Queen because they are very similar
        boolean kingMove = super.moveTo(new_posX, new_posY);
        
        // Check if the move is valid for a King
        if(kingMove && (Math.abs(new_posX.ordinal()-cur_x.ordinal()) == 1 || Math.abs(new_posY-cur_y) == 1)){
            return true;
        }
        return false;
        

    }
}

