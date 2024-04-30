
import javax.swing.SwingUtilities;

/**
 * Entry point for the Chess Game Simulator application.
 * Initializes the GUI and starts the application.
 * The main method creates an instance of buildApp and invokes its createAndShowGUI method.
 * 
 * @author Diego Aviles
 * 
 * @version 1.0
 * @since 2024-04-28
 */
public class Main {
    
     /**
     * Main method to start the Chess Game Simulator application.
     * Creates an instance of buildApp and invokes its createAndShowGUI method.
     *
     * @param args Command-line arguments (unused).
     */
    public static void main(String [] arg){

        SwingUtilities.invokeLater(() -> {
            buildApp.createAndShowGUI();

        });
 }
   
}


