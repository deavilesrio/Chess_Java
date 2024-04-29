package PieceClasses;
import Types.LocationX;
import Types.PieceType;
import chessInterfaces.intFigure;


public abstract class Figure implements intFigure{
    //Fields
   public PieceType name;
   public String color;
   public LocationX cur_x;
   public int cur_y;

    Figure(PieceType name, String color, LocationX cur_x, int cur_y){ //Constructor
        this.name = name;
        this.color = color;
        this.cur_x = cur_x;
        this.cur_y = cur_y;

    }
    public abstract boolean moveTo(LocationX toX, int toY);

    public abstract String toString();
}




