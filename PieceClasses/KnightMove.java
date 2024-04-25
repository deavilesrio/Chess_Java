package PieceClasses;

//Diego Aviles

import Types.LocationX;
import Types.PieceType;

public class KnightMove extends Figure{ //extend it to Queen

    //Constructor
    public KnightMove(PieceType knight, String color, LocationX cur_x, int cur_y){
        super(knight, color, cur_x, cur_y);
    }
    
    public boolean moveTo(LocationX new_posX, int new_posY){ //checks if movement is valid
        LocationX new_x = LocationX.valueOf(new_posX +"");
        if (Math.abs((new_x.ordinal()) - (cur_x.ordinal())) == 2 && Math.abs((8 - new_posY) - (8- cur_y)) == 1 ) {
            // Valid move if the new position is within the board and not occupied
            
            return true;

        }else if( Math.abs((8 - new_x.ordinal()) - (8-cur_x.ordinal())) == 1 && Math.abs(new_posY - cur_y) == 2 ){
            return true;
        }
        return false;
        
    }
    public String toString(){
        return "";
    }
   

   

   
}