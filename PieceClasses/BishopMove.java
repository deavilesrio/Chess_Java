package PieceClasses;
import Types.LocationX;
import Types.PieceType;

public class BishopMove extends Figure {
    //Diego Aviles
    public PieceType name;
    public String color;
    public LocationX cur_x;
    public int cur_y;
    public BishopMove(PieceType Bishop, String color, LocationX cur_posX, int cur_posY){
        super(Bishop, color, cur_posX, cur_posY);//King subclass inherits behaviors of superclass   
        this.cur_x = cur_posX;                                                                                                  
    }
    @Override
    public boolean moveTo( LocationX new_x, int new_posY){
        
        if (Math.abs(new_x.ordinal() - cur_x.ordinal()) == Math.abs( (8-new_posY) - (8 - cur_y))) {
            // Valid move if the new position is within the board and not occupied
            
            return true;

        }
        return false;
        
    }
    public String toString(){
        return "";
    }
        



       
}