import PieceClasses.*;
import Types.LocationX;
import Types.PieceType;
import java.util.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;;
public class buildApp extends Tile {
    static JFrame frame = new JFrame("To-Do List App");
    static Tile[][] boardCells = new Tile[8][8];
    static JPanel boardPanel = new JPanel(new GridLayout(8, 2)); 
    static int curX;
    static LocationX cur_x;
    static int curY;

    static LocationX newX;
    static int newY;

    static Collection<Figure> mylistChess = new ArrayList<>();
    static PieceType pieceName;
    static String colorPiece;
    static boolean doublePiece = false;

    static String [][] board = new String[8][8]; // Change the size as per your requirement

    

    // static Map<Object, Integer> pieces_dictionary = new HashMap<>(); // or other implementations like TreeMap, LinkedHashMap, etc.

    public buildApp(Color backgroundColor) {
        super(backgroundColor);
        //TODO Auto-generated constructor stub
    }
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

        JButton addButton = new JButton("Add");
        JButton moveButton = new JButton("Move");
       
        
        /*
        *                   Unnecesaryy
        * -------------------------------------------------------
        */
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
            // Get the postion text from the text field, trim leading and trail
                String task = current_location.getText().trim();
                
                // Check if the task is not empty, then add it to the to-do list
                if (!task.isEmpty()) {
                    String [] arrOfnextMove = task.split(", ", 2);
                 
                    curY = Integer.parseInt(arrOfnextMove[1]);   //store in field current y
                    String num_x = arrOfnextMove[0].toUpperCase(); //make the character uppercase
                    // //conversion from String to Location X type
                    cur_x = LocationX.valueOf(num_x); 
                   
                    //Gets color piece
                    Object selectedItem = color_dropdown_list.getSelectedItem();
                    colorPiece =  selectedItem.toString();
                    //Gets Piece Name
                    String pieceString = String.valueOf(piece_dropdown_list.getSelectedItem());
                    pieceName = PieceType.valueOf(pieceString.toUpperCase());

                    /* Checks if the piece already in the the collection myListChess, meaning piece was already used */
                    for(Figure piece : mylistChess){
                        if(piece.name.equals(pieceName) ){
                            doublePiece = true;
                        }else{
                            doublePiece = false;
                        }

                    }
                    if(piece_dropdown_list.getSelectedItem().equals("Pawn") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        mylistChess.add( new PawnMove(pieceName, colorPiece, cur_x, curY));
                        //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem(), i);
                        
                    }else if(piece_dropdown_list.getSelectedItem().equals("Knight") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
        
                        mylistChess.add( new KnightMove(pieceName, colorPiece, cur_x, curY));

                        //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem());                 
                    
                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("Bishop") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new BishopMove(pieceName, colorPiece, cur_x, curY));

                        //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem());                  
                    
                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("Rook") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                       
                        mylistChess.add( new RookMove(pieceName, colorPiece, cur_x, curY));

                            //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem());                
                        
                        }
                    else if(piece_dropdown_list.getSelectedItem().equals("Queen") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new QueenMove(pieceName, colorPiece, cur_x, curY));

                        //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem());                 
                    
                    }
                    else if(piece_dropdown_list.getSelectedItem().equals("King") && !doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        
                        mylistChess.add( new KingMove(pieceName, colorPiece, cur_x, curY));

                            //pieces_dictionary.put(piece_dropdown_list.getSelectedItem().getSelectedItem());                
                        
                    }
                    if(!doublePiece && board[8-curY][cur_x.ordinal()] == null ){
                        Icon icon = new ImageIcon("C:\\Users\\diego\\OneDrive\\Desktop\\CS_Lab\\Adv_Obj\\Lab6\\art\\" + color_dropdown_list.getSelectedItem() +"_"+ piece_dropdown_list.getSelectedItem()+ ".gif");
                        System.out.println("test");
                        board[8-curY][cur_x.ordinal()] = pieceString; //Adds a the piece name to an array of strings, to know where are the pieces located
                        boardCells[8-curY][cur_x.ordinal()].setPieceIcon(icon); //adds the image of the piece in the tile of the GUI Board
                    }else if(board[8-curY][cur_x.ordinal()] != null){
                        JOptionPane.showMessageDialog(frame, "Position is occupied!", "Pop-out Window", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        //Pop out window to display warning messeage
                        JOptionPane.showMessageDialog(frame, "Piece already in board!", "Pop-out Window", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }
            }
        });
            // ActionListener for the "Remove Task" button
        moveButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String task = current_location.getText().trim();
                String [] arrOfnextMove = task.split(", ", 2);
                 
                newY = Integer.parseInt(arrOfnextMove[1]);   //store in field current y
                String num_x = arrOfnextMove[0].toUpperCase(); //make the character uppercase
                //conversion from String to Location X type
                newX = LocationX.valueOf(num_x); 
                
                String messeage = "";
                for (Figure piece : mylistChess) {
                    //Checks all the pieces in board, if there are able to move                                  
                    
                    boolean isValid = piece.moveTo(newX, newY); //Calls the method that validates or not if movement is possible for a certain piece
                    if (isValid) {
                        messeage += piece.name + " at " + piece.cur_x + ", " + piece.cur_y + " can move to " + newX + ", " + newY + ".\n";
                        System.out.print(messeage);
                    } else {
                        messeage += piece.name + " at " + piece.cur_x + ", " + piece.cur_y + " can not move to " + newX + ", " + newY + ".\n";
                        System.out.print(messeage);
                    }
                }
                JOptionPane.showMessageDialog(frame, messeage, "Pop-out Window", JOptionPane.INFORMATION_MESSAGE); // Pops a windows to show which pieces can move
                
                
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
       
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Color backgroundColor = (row + col) % 2 == 0 ? Color.WHITE : Color.GRAY;
                Tile tile = new Tile(backgroundColor);
                tile.setPreferredSize(new Dimension(75, 75));
                boardCells[row][col] = tile;
                boardPanel.add(tile);
            }
        }
        
    }
    
}