

import chessInterfaces.buildApp;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;
/**
 * Class representing the movement behavior of a bishop chess piece.
 * Extends the Figure class.
 * 
 * @author Diego Aviles
 * @version 1.0
 * @since 2024-04-20
 */
public class TestPostion {
    /**
     * Method Tests if the the function getInitialPosition works, and returns the correct output.
     */
    @Test
    public void Test_Ini_Pos(){

        SwingUtilities.invokeLater(() -> {
            assertEquals(true, buildApp.getInitialPosition("a, 5"));
            assertEquals(false, buildApp.getInitialPosition("adsajdsa"));
        });

    }
    /**
     * Method Tests if the the function getFinalPosition works, and returns the correct output.
     */
    @Test
    public void Test_final_Pos(){

        SwingUtilities.invokeLater(() -> {
            assertEquals(true, buildApp.getFinalPosition("a, 9"));
            assertEquals(false, buildApp.getFinalPosition("djashdjhsakdf"));

        });

    }


}
