/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.views;

import Business.element.Coordinates;
import Business.element.Path;
import Business.transfer.Transfer;
import View.controller.Controller;
import View.controller.Event;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Main view
 * @author Diego Laguna Martín
 */
public class MainView extends JFrame implements ActionListener{
    
    private int size;
    private int high;
    private Board board;
    int[][] obstacleMap;
    private Controller controller;
    
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonResize;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel panelBoard;
    private javax.swing.JPanel panelInputs;
    private javax.swing.JLabel jLabelIni;
    private javax.swing.JTextField textFieldIniX;
    private javax.swing.JTextField textFieldIniY;
    private javax.swing.JLabel jLabelGoal;
    private javax.swing.JTextField textFieldGoalX;
    private javax.swing.JTextField textFieldGoalY;
    private javax.swing.JTextField textFieldSizeBoard;
    private javax.swing.JTextField textFieldHighBoard;
    private JPanel panelInputsIni;
    private JPanel panelInputsGoal;
    private JPanel panelInputsSize;
    private JPanel panelInputsIniGoal;
    private JPanel panelSizeInputs;
    private JPanel panelInsputs;
    private String stringSizeTimeBoard;

    /**
     * Constructor
     * @param size
     * @param high 
     */
    public MainView(int size, int high) {
        this.size = size;
        this.high = high;
        controller = new Controller(size, high);
        board = new Board(size, high);
        board.initListeners(this);
        obstacleMap = new int[size + 1][high + 1];
        create();
        addEventHandler();
    }
    
    /**
     * Add a event handler
     */
    private void addEventHandler() {
        ViewActionListener actionListener = new ViewActionListener();
        ViewKeyListener keyListener = new ViewKeyListener();
        ViewFocusListener focusListener = new ViewFocusListener();
        //ActionListener
        jButtonStart.addActionListener(actionListener);
        jButtonResize.addActionListener(actionListener);
        jButtonReset.addActionListener(actionListener);
        //KLListener
        jButtonStart.addKeyListener(keyListener);
        jButtonResize.addKeyListener(keyListener);
        jButtonReset.addKeyListener(keyListener);
        //FLListener
        textFieldIniY.addFocusListener(focusListener);
        textFieldGoalY.addFocusListener(focusListener);
    }
    
    /**
     * Create the main view
     */
    private void create() {
        //Variables
        String nombre = "Diego Laguna Martín";
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(1200, 1000);
        this.setTitle("A* Algorithm - Diego Laguna Martín");
        jLabelName = new javax.swing.JLabel();
        jButtonStart = new javax.swing.JButton("Start");
        ImageIcon img= new ImageIcon(this.getClass().getResource("/Images/reset.png"));
        jButtonReset = new javax.swing.JButton();
        jButtonReset.setIcon(img);
        jButtonResize = new javax.swing.JButton("Resize");
        textFieldIniX = new javax.swing.JTextField(5);
        textFieldIniY = new javax.swing.JTextField(5);
        textFieldGoalX = new javax.swing.JTextField(5);
        textFieldGoalY = new javax.swing.JTextField(5);
        textFieldHighBoard = new javax.swing.JTextField(5);
        textFieldSizeBoard = new javax.swing.JTextField(5);
        jLabelIni = new javax.swing.JLabel();
        jLabelGoal = new javax.swing.JLabel();
        panelBoard = new javax.swing.JPanel();
        panelInputs = new JPanel();
        panelInputsIni = new JPanel();
        panelInputsGoal = new JPanel();
        panelInputsSize = new JPanel();
        panelInputsIniGoal = new JPanel();
        panelInsputs = new JPanel();
        panelSizeInputs = new JPanel();
        stringSizeTimeBoard = "Board[ " + size + "x" + high + " ]";
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jLabelName.setText(nombre);
        jLabelIni.setText("Start:");
        jLabelGoal.setText("Goal:");
        panelInputsIniGoal.setLayout(new BorderLayout());
        this.setLayout(new BorderLayout());
        panelBoard.add(board);
        panelInputs.setLayout(new FlowLayout());
        panelInputsIni.add(textFieldIniX);
        panelInputsIni.add(textFieldIniY);
        panelInputsIni.setBorder(BorderFactory.createTitledBorder("Start"));
        panelInsputs.add(panelInputsIni);
        panelInputsGoal.add(textFieldGoalX);
        panelInputsGoal.add(textFieldGoalY);
        panelInputsGoal.setBorder(BorderFactory.createTitledBorder("Goal"));
        panelInsputs.add(panelInputsGoal);
        panelInputsIniGoal.add(panelInsputs);
        panelInputsIniGoal.add(jButtonStart, BorderLayout.SOUTH);
        panelInputsSize.setLayout(new BorderLayout());
        panelSizeInputs.add(textFieldSizeBoard);
        panelSizeInputs.add(textFieldHighBoard);
        panelInputsSize.add(panelSizeInputs);
        panelInputsSize.setBorder(BorderFactory.createTitledBorder(stringSizeTimeBoard));
        panelInputsSize.add(jButtonResize, BorderLayout.SOUTH);
        panelInputs.add(panelInputsIniGoal, BorderLayout.SOUTH);
        panelInputs.add(panelInputsSize, BorderLayout.SOUTH);
        panelInputs.add(jButtonReset, BorderLayout.SOUTH);
        this.add(board, BorderLayout.CENTER);
        this.add(panelInputs, BorderLayout.SOUTH);
        setSize(1000, 700);
        setLocationRelativeTo(this);
        textFieldIniX.requestFocus();
    }

    /**
     * Draw the path
     * @param minimumPath
     * @param start
     * @param goal 
     */
    private void drawPath(Path minimumPath, Coordinates start, Coordinates goal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (minimumPath == null) {
                    JOptionPane.showMessageDialog(null, "There is no possible way");
                    restoreView();
                } 
                else {   
                    for (int x = 0; x < size; x++) {
                        for (int y = 0; y < high; y++) {
                            if (minimumPath.contains(x, y)) {
                                try {
                                    //Wait to paint the cell
                                    Thread.sleep(120);
                                    board.drawPathCell(x, y);
                                } 
                                catch (InterruptedException e) {
                                    JOptionPane.showMessageDialog(null, "ERROR");
                                }
                            } 
                            else {
                                if (obstacleMap[x][y] != 1) board.drawEmptyCell(x, y);
                                if (start.getX()== x && start.getY() == y) board.drawStartCell(x, y);
                                if (goal.getX() == x && goal.getY() == y) board.drawStartCell(x, y);                  
                            }
                        }
                    }
                    int xGoal = Integer.parseInt(textFieldGoalX.getText()) - 1;
                    int yGoal = Integer.parseInt(textFieldGoalY.getText()) - 1;
                    board.drawGoalCell(xGoal, yGoal);
                }
            }
        }).start();
    }
    
    /**
     * Restore the main view
     */
    protected void restoreView() {
        dispose();
        new MainView(size, high).draw();
    }
    
    /**
     * Draw the main view 
     */
    public void draw() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                setVisible(true);
            }
        });
    }
    
    /**
     * Actionperformed to draw obstacles
     * @param arg0 
     */
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Cell cell = (Cell) arg0.getSource();
        board.drawObstacleCell(cell.getRow(), cell.getColumn());
        obstacleMap[cell.getRow()][cell.getColumn()] = 1;
    }

    /**
     * Class view action listener
     */
    public class ViewActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            
            //Start button
            if (event.getSource() == jButtonStart) {
                try {
                    int xStart = Integer.parseInt(textFieldIniX.getText()) - 1;
                    int yStart = Integer.parseInt(textFieldIniY.getText()) - 1;
                    int xGoal = Integer.parseInt(textFieldGoalX.getText()) - 1;
                    int yGoal = Integer.parseInt(textFieldGoalY.getText()) - 1;
                    
                    if (xStart > size - 1)JOptionPane.showMessageDialog(null,"Initial X coordinate out of range");
                    else if (yStart > high - 1)JOptionPane.showMessageDialog(null,"Initial Y coordinate out of range");
                    else if (xGoal > size - 1) JOptionPane.showMessageDialog(null,"Goal X coordinate out of range");
                    else if (yGoal > high - 1) JOptionPane.showMessageDialog(null,"Goal Y coordinate out of range");
                    else {
                        Coordinates coord_Start = new Coordinates(xStart,yStart);
                        Coordinates coord_Goal = new Coordinates(xGoal, yGoal);
                        Transfer transfer = new Transfer(coord_Start, coord_Goal, obstacleMap);
                        
                        //Calculate the minimum path
                        Transfer cost = (Transfer) controller.action(Event.CALCULATE_MINIMUM_PATH, transfer);
                        Path minimumPath = (Path) controller.action( Event.GET_MINIMUM_PATH, null);
                        panelInputsSize.setBorder(BorderFactory.createTitledBorder(stringSizeTimeBoard.concat(" - " + cost.getTime()+ " ms")));
                        drawPath(minimumPath, coord_Start, coord_Start);
                    }
                } 
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null,"Enter valid digit");
                }
            }
            
            //Resize button
            if (event.getSource() == jButtonResize) {
                try {
                    int size = Integer.parseInt(textFieldSizeBoard.getText());
                    int high = Integer.parseInt(textFieldHighBoard.getText());

                    MainView.this.high = high;
                    MainView.this.size = size;
                } 
                catch (NumberFormatException e1) {
                                    JOptionPane.showMessageDialog(null,"Enter valid digit");
                }

                MainView.this.restoreView();
            }

            //Reset button
            if (event.getSource() == jButtonReset) MainView.this.restoreView();

        }
    }

    /**
     * Class view key lisener
     */
    public class ViewKeyListener implements KeyListener {
        
        @Override
        public void keyPressed(KeyEvent arg0) {
            if (arg0.getKeyCode() == 10) {
                //Start button
                if (jButtonStart.isFocusOwner()) {
                        jButtonStart.doClick();
                        jButtonStart.requestFocus();
                }
                
                //Resize button
                if (jButtonResize.isFocusOwner()) {
                        jButtonResize.doClick();
                }
                
                //Reset button
                if (jButtonReset.isFocusOwner()) {
                        jButtonReset.doClick();
                }
            }

        }
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    /**
     * Class view focus listener
     */
    public class ViewFocusListener implements FocusListener {

        @Override
        public void focusLost(FocusEvent arg0) {
            if (arg0.getSource() == textFieldIniY) {
                try {
                    int xStart = Integer.parseInt(textFieldIniX.getText()) - 1;
                    int yStart = Integer.parseInt(textFieldIniY.getText()) - 1;
                    if (xStart > size - 1) JOptionPane.showMessageDialog(null, "Initial X coordinate out of range");
                    else if (yStart > high - 1) JOptionPane.showMessageDialog(null, "Initial Y coordinate out of range");
                    else board.getCell(xStart, yStart).setStartColor();

                } 
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid digit");
                }
            }
            if (arg0.getSource() == textFieldGoalY) {
                try {
                    int xGoal = Integer.parseInt(textFieldGoalX.getText()) - 1;
                    int yGoal = Integer.parseInt(textFieldGoalY.getText()) - 1;
                        if (xGoal > size - 1)
                                JOptionPane.showMessageDialog(null, "Goal X coordinate out of range");
                        else if (yGoal > high - 1)
                                JOptionPane.showMessageDialog(null, "Goal Y Final fuera de rango");
                        else board.getCell(xGoal, yGoal).setGoalColor();         
                } 
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Enter valid digit");
                }
            }
        }

        @Override
        public void focusGained(FocusEvent e) {
            System.out.println("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
