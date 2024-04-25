package PieceClasses;
import Types.LocationX;
import Types.PieceType;

public class RookMove extends Figure{

    public RookMove(PieceType rook, String color, LocationX cur_posX, int cur_posY){
        super(rook, color, cur_posX, cur_posY);
    }


       @Override
       public boolean moveTo( LocationX new_posX, int new_posY){
           //This is making the user String input into a number so it is easier to compare 
               
                   if(new_posX.ordinal() == cur_x.ordinal() || cur_y == new_posY){
                     return true;
                  }else{
                   return false;
                  }
               
        }
        
        public String toString(){
            return "";
        }
    
}
