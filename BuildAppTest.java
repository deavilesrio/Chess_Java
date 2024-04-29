import static org.junit.Assert.*;

import org.junit.Test;

import PieceClasses.KnightMove;


public class BuildAppTest {
    
    @Test
    public void testInitial(){
        KnightMove knight = new KnightMove(knight, null, 1, 1);
        assertEquals(true, knight.moveTo(2, 3));
    }

}


