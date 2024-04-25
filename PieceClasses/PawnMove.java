package PieceClasses;
import Types.LocationX;
import Types.PieceType;

public class PawnMove extends Figure{
    
    public PawnMove(PieceType pawn, String color, LocationX cur_posX, int cur_posY){
        super(pawn, color, cur_posX, cur_posY);
    }
    
    @Override 
    public boolean moveTo(LocationX new_posX, int new_posY){
    
        if(color.equals("White")){
            
            if(8-cur_y == 6){
                
                if(((8-new_posY == 8-cur_y-1) && (new_posX.ordinal() == cur_x.ordinal())) || ((8-new_posY == 8-cur_y-2) && (new_posX.ordinal() == cur_x.ordinal()))){
                    return true;
                }
                
            }else{
                if(8-new_posY == 8-cur_y-1 && new_posX.ordinal() == cur_x.ordinal()){
                    return true;
                }
            }
        }else if(color.equals("Black")){
            
            if(8-cur_y == 1){
                
                if((8-new_posY == 8-cur_y+1 && new_posX.ordinal() == cur_x.ordinal()) || (8-new_posY == 8-cur_y+2 && new_posX.ordinal() == cur_x.ordinal())){
                    return true;
                }
            }else{
                if(8-new_posY == 8-cur_y+1 && new_posX.ordinal() == cur_x.ordinal()){
                    return true;
                }
            }
        }
        return false;

    }
    public String toString(){
        return "";
    }
}