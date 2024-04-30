import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import PieceClasses.BishopMove;
import PieceClasses.Figure;
import PieceClasses.KingMove;
import PieceClasses.KnightMove;
import PieceClasses.PawnMove;
import PieceClasses.QueenMove;
import PieceClasses.RookMove;
import Types.LocationX;
import Types.PieceType;;

/**
 * Main class for the chess game
 * Class for building a chess application GUI
 * @author Diego Aviles
 * @author Devin Lara
 * @author Anthony Trancoso
 * 
 * @version 3.0
 * @since 2024-04-28
 */

public class buildApp extends Tile {
    /**static fields for the GUI components and game state */
    static JFrame frame = new JFrame("Chess Game Simulator");
    static Tile[][] boardCells = new Tile[8][8];
    static JPanel boardPanel = new JPanel(new GridLayout(8, 2)); 

    /**static fields for the positions of the chess piece */
    static int curX;
    static LocationX cur_x;
    static int curY;
    static int chessCount;
    static LocationX newX;
    static int newY;

    /**static fields for the attributes of chess pieces */
    static Set<PieceType> chosenPieces = new HashSet<>();
    static Collection<Figure> mylistChess = new ArrayList<>();
    static PieceType pieceName;
    static String colorPiece;
    static boolean doublePiece = false;

    static String [][] board = new String[8][8]; // Change the size as per your requirement

    

    // static Map<Object, Integer> pieces_dictionary = new HashMap<>(); // or other implementations like TreeMap, LinkedHashMap, etc.

    /**
     * Constructor for the buildApp class
     * @param backgroundColor The background color of the GUI components
     */
    public buildApp(Color backgroundColor) {
        super(backgroundColor);
        //TODO Auto-generated constructor stub
    }

    /**
     * Creates and displays the GUI for the chess game
     */
    public static void createAndShowGUI(){
        /* Drop downlists
         * -----------------------------------------------------------------------------------
         */
        String pieces[] = { "Pawn", "Knight", "Bishop", "Rook", "Queen", "King" };
        String color[] = { "White", "Black"};
        JComboBox<String> piece_dropdown_list = new JComboBox<>(pieces); 
        JComboBox<String> color_dropdown_list = new JComboBox<>(color);

        // ----------------------------------------------------------------------------------------
        
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        
        JLabel l, l1;
        l = new JLabel("Select Piece");
        l1 = new JLabel("");
 
        // set color of text
        l.setForeground(Color.red);
        l1.setForeground(Color.blue);
        // JTextField with smaller height
        JTextField current_location = new JTextField(5);
        JTextField new_location = new JTextField(0);

        //adds buttons for the functionality of the game
        JButton addButton = new JButton("Add");
        JButton moveButton = new JButton("Move");
        moveButton.setEnabled(false);
       
        
        /*
        *                   Unnecesaryy
        * -------------------------------------------------------
        */
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {

                //mylistChess.clear();
                clearBoard();
            // Get the postion text from the text field, trim leading and trail
                String task = current_location.getText().trim();
                
                // Check if the task is not empty, then add it to the to-do list
                if (!task.isEmpty()) {
                    String [] arrOfnextMove = task.split(", ", 2);
                 
                    curY = Integer.parseInt(arrOfnextMove[1]);   //store in field current y
                    String num_x = arrOfnextMove[0].toUpperCase(); //make the character uppercase
                    System.out.println("num_x" + num_x);
                    // //conversion from String to Location X type
                    cur_x = LocationX.valueOf(num_x); 
                   
                    //Gets color piece
                    Object selectedItem = color_dropdown_list.getSelectedItem();
                    colorPiece =  selectedItem.toString();
                    //Gets Piece Name
                    String pieceString = String.valueOf(piece_dropdown_list.getSelectedItem());
                    pieceName = PieceType.valueOf(pieceString.toUpperCase());

                    chosenPieces.add(pieceName);
                    disableChosenPieces(piece_dropdown_list);

                    /* Checks if the piece already in the the collection myListChess, meaning piece was already used */
                    for(Figure piece : mylistChess){
                        if(piece.name.equals(pieceName) ){
                            doublePiece = true;
                            break;
                        }else{
                            doublePiece = false;
                        }

                    }
                    if(piece_dropdown_list.getSelectedItem().equals("Pawn") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new PawnMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;
                        
                    }else if(piece_dropdown_list.getSelectedItem().equals("Knight") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
        
                        mylistChess.add( new KnightMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;

                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("Bishop") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new BishopMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;    

                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("Rook") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                       
                        mylistChess.add( new RookMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;
                        
                        }
                    else if(piece_dropdown_list.getSelectedItem().equals("Queen") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new QueenMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;
                    
                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("King") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new KingMove(pieceName, colorPiece, cur_x, curY));
                        chessCount++;
                        
                    }
                    if(!doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        Icon icon = new ImageIcon("art/" + color_dropdown_list.getSelectedItem() +"_"+ piece_dropdown_list.getSelectedItem()+ ".gif");
                        //System.out.println("test");
                        board[8-curY][cur_x.ordinal()] = pieceString; //Adds a the piece name to an array of strings, to know where are the pieces located
                        boardCells[8-curY][cur_x.ordinal()].setPieceIcon(icon); //adds the image of the piece in the tile of the GUI Board
                        addButton.setEnabled(false);
                        moveButton.setEnabled(true);
                    }else if(board[8-curY][cur_x.ordinal()] != null){
                        //displays message if occupied
                        JOptionPane.showMessageDialog(frame, "Position is occupied!", "Pop-out Window", JOptionPane.INFORMATION_MESSAGE);
                        addButton.setEnabled(true);
                        moveButton.setEnabled(false);
                    }
                    else{
                        //Pop out window to display warning messeage
                        JOptionPane.showMessageDialog(frame, "Piece already in board!", "Pop-out Window", JOptionPane.INFORMATION_MESSAGE);
                        addButton.setEnabled(true);
                        moveButton.setEnabled(false);
                    }
                    
                }
              
            }
        });
           
        moveButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String task = new_location.getText().trim();
                String[] arrOfnextMove = task.split(", ", 2);
                newX = LocationX.valueOf(arrOfnextMove[0].toUpperCase());
                newY = Integer.parseInt(arrOfnextMove[1]);
                 
                String messeage = "";
            

                for (Figure piece : mylistChess) {
                    //Checks all the pieces in board, if there are able to move                                  
                    
                    boolean isValid = piece.moveTo(newX, newY); //Calls the method that validates or not if movement is possible for a certain piece
                    System.out.println(boardCells[8 - newY][newX.ordinal()].getPieceIcon());
                    if (isValid && (piece.cur_x != newX || piece.cur_y != newY) ) {
                        messeage = piece.name + " at " + piece.cur_x + ", " + piece.cur_y + " can move to " + newX + ", " + newY + ".\n";
                        System.out.print(messeage);
                        //changes button functionality
                        addButton.setEnabled(true);
                        moveButton.setEnabled(false);

                        boardCells[8 - piece.cur_y][piece.cur_x.ordinal()].setPieceIcon(null);
                        mylistChess.remove(piece); //remove from collection
                        piece.cur_x = newX;
                        piece.cur_y = newY;

                        //sets old position with null and new position with icon gif
                        Icon iconn = new ImageIcon("art/" + colorPiece + "_" + piece.name + ".gif");
                        boardCells[8 - newY][newX.ordinal()].setPieceIcon(iconn);
                        board[8 - piece.cur_y][piece.cur_x.ordinal()] = null;
                    } else if(piece.cur_x == newX && piece.cur_y == newY){
                        //displays message for unvalid position
                        System.out.print("Please select another position for" + piece.name);
                        JOptionPane.showMessageDialog(frame, "Position not available!", "Pop-out Window", JOptionPane.INFORMATION_MESSAGE);
                        addButton.setEnabled(false);
                        moveButton.setEnabled(true);
                    } else {
                        messeage = piece.name + " at " + piece.cur_x + ", " + piece.cur_y + " can not move to " + newX + ", " + newY + ".\n";
                        System.out.print(messeage);
                        addButton.setEnabled(true);
                        moveButton.setEnabled(false);
                    }
                }
                JOptionPane.showMessageDialog(frame, messeage, "Pop-out Window", JOptionPane.INFORMATION_MESSAGE); // Pops a windows to show which pieces can move
                
                board[8 - newY][newX.ordinal()] = null;
                new_location.setText("");
                System.out.print(chessCount);
                if (chessCount == 6){
                    frame.dispose();
                } else{
                    int option = JOptionPane.showConfirmDialog(frame, "Do you want to terminate the application?", "Terminate Application", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        frame.dispose(); // Close the frame
                    }
                }

            }
        });
        /* --------------------------------------------------------------- */
       
        
        /* Container basically holds every panel and label of the GUI
         * -----------------------------------------------------------------------------------------
         */
        JPanel dropDownPanel = new JPanel();
        JLabel current = new JLabel("Current:");
        JLabel new_pos = new JLabel("New:");
        dropDownPanel.setLayout(new BoxLayout(dropDownPanel, BoxLayout.Y_AXIS)); // Set layout to vertical

        // Add piece_dropdown_list
        dropDownPanel.add(piece_dropdown_list);
        
        // Add vertical space
        dropDownPanel.add(Box.createVerticalStrut(20)); // Adjust the height as needed
        
        // Add color_dropdown_list
        dropDownPanel.add(color_dropdown_list);

        dropDownPanel.add(Box.createVerticalStrut(20)); // Adjust the height as needed
        dropDownPanel.add(current);
        // add current_coordiantes
        dropDownPanel.add(current_location);

        dropDownPanel.add(Box.createVerticalStrut(20)); // Adjust the height as needed
        dropDownPanel.add(new_pos);
        // add new_coordiantes
        dropDownPanel.add(new_location);
        // Create a JPanel to hold the buttons

        JPanel buttonPanel = new JPanel();
       
        buttonPanel.add(addButton);
        buttonPanel.add(moveButton);
        

        // Create a panel to hold the dropDownPanel and center it horizontally
        JPanel westPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Align the dropdown list to the left
        westPanel.add(dropDownPanel, gbc);

        // Add components to the frame
        initializeBoard();
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(westPanel, BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        //-------------------------------------------------------------------------------
        frame.setVisible(true);
    }
    private static void initializeBoard() {
        
        /*Use GridLayout with 8 rows and 2 columns 
        This is making that the chess border stays in the center */
       
        /**
         * Initialies the chessboard GUI by creating the tiles
         * Each tile represents a square on the chessboard
         */
        for (int row = 0; row < 8; row++) {
            //Iterate over each row and column to create tiles
            for (int col = 0; col < 8; col++) {
                Color backgroundColor = (row + col) % 2 == 0 ? Color.WHITE : Color.GRAY;
                //create a new tile with the calculated background color
                Tile tile = new Tile(backgroundColor);
                tile.setPreferredSize(new Dimension(75, 75));
                //store the tile in the 2D array and add it to the board panel
                boardCells[row][col] = tile;
                boardPanel.add(tile);
            }
        }
        
    }

    /**
     * Clears the chessboard by removing all pieces and icons from the tiles.
     * Sets the board array and piece icons to null.
     */
    private static void clearBoard(){
        //iterate over each row and column of the chessboard
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                //set the piece name in the board array to null
                board[i][j] = null;
                //set the piece icon on the tile to null
                boardCells[i][j].setPieceIcon(null);
            }
        }
    }

    /**
     * Disables the selection of pieces that have already been chosen.
     * Removes items from the JComboBox representing the available piece choices
     * based on the pieces already selected and stored in the chosenPieces collection.
     *
     * @param pieceDropdownList The JComboBox containing the list of available piece choices.
     *                          The method removes items from this dropdown list based on the pieces already chosen.
     * @see JComboBox
     * @see PieceType
     */
    private static void disableChosenPieces(JComboBox<String> pieceDropdownList){
        // Iterate through each piece that has been chosen
        for (PieceType piece : chosenPieces){
            // Remove the item representing the chosen piece from the dropdown list
            pieceDropdownList.removeItem(piece.toString());
        }
    }
    
}

