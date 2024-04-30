import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Represents a single tile on the chessboard.
 * Each tile can hold a chess piece image.
 * 
 * @author Diego Aviles
 * @author Devin Lara
 * @author Anthony Trancoso
 * @version 1.0
 * @since 2024-04-28
 */
public class Tile extends JPanel {
    private JLabel pieceLabel; // Label to display the chess piece image

    /**
     * Constructs a new Tile with the specified background color.
     * Initializes the layout, sets the background color, and adds a piece label to the center.
     * 
     * @param backgroundColor The background color of the tile.
     */
    public Tile(Color backgroundColor) {
        this.setLayout(new BorderLayout()); // Use BorderLayout for flexibility
        this.setBackground(backgroundColor);
        this.pieceLabel = new JLabel("",SwingConstants.CENTER);
        this.add(pieceLabel, BorderLayout.CENTER); // Add the label to the center of the tile
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Optional: adds a border to each tile
    }

    /**
     * Sets the icon of the chess piece displayed on the tile.
     * 
     * @param icon The icon representing the chess piece.
     */
    public void setPieceIcon(Icon icon) {
        pieceLabel.setIcon(icon); // Set the chess piece image
    }

    /**
     * Clears the icon of the chess piece displayed on the tile.
     */
    public void clearPieceIcon() {
        pieceLabel.setIcon(null);
    }

     /**
     * Retrieves the icon of the chess piece displayed on the tile.
     * 
     * @return The icon representing the chess piece, or null if no piece is present.
     */
    public Icon getPieceIcon() {
        return pieceLabel.getIcon();
    }
    
}

