package PieceClasses;

import Types.LocationX;
import Types.PieceType;

public class KingMove extends QueenMove{ //King is extended from Queen
    
    public KingMove(PieceType king, String color, LocationX cur_posX, int cur_posY){
        super(king, color, cur_posX, cur_posY); //King subclass inherits behaviors of superclass                                                                                                     Queen
    }
    
    @Override 
    //Method to check if the moving chess piece is valid
    public boolean moveTo( LocationX new_posX, int  new_posY){
        
       //Will check if move is valid from Queen because they are very similar
        boolean kingMove = super.moveTo(new_posX, new_posY);
        
        
        if(kingMove && (Math.abs(new_posX.ordinal()-cur_x.ordinal()) == 1 || Math.abs(new_posY-cur_y) == 1)){
            return true;
        }
        return false;
        

    }
}