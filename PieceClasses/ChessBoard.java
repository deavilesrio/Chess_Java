package PieceClasses;
import Types.LocationX;
import chessInterfaces.IntChessBoard;
public class ChessBoard implements IntChessBoard {
    public boolean verifyCoordinate(LocationX row, int col){
        
        return row.ordinal() >= 0 && row.ordinal() < 8 && col >= 0 && col < 8;
    }
    
}
