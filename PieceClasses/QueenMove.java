package PieceClasses;
import chessInterfaces.intBishop;
import Types.LocationX;
import Types.PieceType;

public class QueenMove extends RookMove implements intBishop { //extend it to Rook
    public QueenMove(PieceType queen, String color, LocationX cur_posX, int cur_posY){
        super(queen, color, cur_posX, cur_posY );
    }

    @Override
    public boolean moveTo( LocationX new_posX, int new_posY){
        //This is making the user String input into a number so it is easier to compare 
            
            //this always it to get the isMoveValid from the Rook class
            boolean RookMove = super.moveTo(new_posX, new_posY);

            // if(!isValidSquare(cur_posX,cur_posY)){
            //     System.out.println("Not a valid move!");
            //     return false;
            // }  
            // put the rook method right here
                if(RookMove || moveToBishop(new_posX, new_posY) ){
                  return true;
               }else{
                return false;
               }
            
    }
    @Override
    public boolean moveToBishop(LocationX new_posX, int new_posY){
        if (Math.abs(new_posX.ordinal() - cur_x.ordinal()) == Math.abs( (8-new_posY) - (8 - cur_y)) ) {
            // Valid move if the new position is within the board and not occupied
            
            return true;

        }
        return false;
    }
}
