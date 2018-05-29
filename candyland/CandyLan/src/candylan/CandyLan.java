/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Owner
 */
public class CandyLan extends JPanel implements MouseListener {

    String[] colors = {"red", "yellow", "blue", "purple", "orange", "green"}; // colors used to create the board and keep track of players locations
    static Deck d;
    Board b;
    Rectangle r;
    Circle c1;
    Circle c2;
    Player p1 = new Player();
    Player p2 = new Player();
    private int turn = 1; //tells us who's turn it is (increments everytime you move)
    static Circle indicator1 = new Circle(25, 617, Color.black, 25); //shows which circle represents which player (indicates)
    static Circle indicator2 = new Circle(25, 692, Color.white, 25); //instantiates location, color, and size of circle
    Arrow arr; //indicator showing which player's turn it is
    Card card = new Card("black"); //creates an object that allows us to paint the current card to the screen

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {

        CandyLan frame = new CandyLan("CandyLAN"); //starts a new game
        d.shuffle(); //shuffles the deck
        
        JOptionPane.showMessageDialog(null, "Player 1 is the black circle!" + "\n" + "Player 2 is the white circle!"); //tells which player is which circle
    }

    public CandyLan(String candyLAN) {
        JFrame frame = new JFrame("CandyLAN"); //frame to add graphical components
        frame.setSize(1200, 800); //sets size of the window

        d = new Deck(colors); //creates a new deck with the colors and characters declared before
        b = new Board(colors); //creates a new board with the colors

        r = new Rectangle(); //creates the board
        c1 = new Circle(); //creates the players pieces on the board
        c2 = new Circle(40, 50, Color.white);
        
        int[] arrowsx = {60, 135, 135};
        int[] arrowsy = {630, 605, 655};
       
        arr = new Arrow(arrowsx, arrowsy);
        
        
        Font font = new Font("SansSerif", Font.PLAIN, 40); //makes the font that is used on the button and indicator fields
        
        Button move = new Button("Draw Card"); //creates button that allows the players to be moved
        move.setFont(font); //sets the buttons font to the one created above
        move.setBounds(985, 611, 200, 150); //tells where and how large the button is
        move.addMouseListener(this); //adds a mouse listener to the button so that we can do something when it is clicked
        
        //adds the button and itself to the frame
        frame.add(move);
        frame.add(this);
        
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //when you hit the x it closes the window
        frame.setVisible(true); //makes it visible
    }

    @Override
    
    //displays all of the components on the screen
    public void paint(Graphics g) {
        super.paintComponent(g);
        arr.paintComponent(g); //paints the arrow that shows whos turn it is
        r.paintComponent(g); //paints the board
        c1.paintComponent(g); //paints the pieces
        c2.paintComponent(g);
        
        g.setColor(Color.white);
        g.fillRect(758,605,185,205);
        card.paintComponent(g);

        indicator1.paintComponent(g); //paints the circles that tell the players which circle is which player
        indicator2.paintComponent(g);
    }

    //detects a mouse click and moves the on of the players, depending on whos turn it is
    @Override
    public void mouseClicked(MouseEvent e) {
        if(turn%2 == 1){ //if turn is odd, player one's turn
            p1.move(b.getSpaces(), d.draw()); //move the player to the next spot that is the same color as the card
            int location1 = p1.getLocation(); //gets index of where player is on the board
            Point current1 = r.getPoints().get(location1); //gets coordinates of space that the player is moving to
            c1.setX(current1.getX()+15); //moves the player to that location
            c1.setY(current1.getY()+5);
            arr.changeDown(); //indicator arrow changes position
            card = d.getDeck().get(d.getCurrent()); //changes the card that's on screen to the one that was just drawn
            repaint(); //repaints the board with new coordinates
        } else { //if turn is even, do the same thing for player 2
            p2.move(b.getSpaces(), d.draw());
            int location2 = p2.getLocation();
            Point current2 = r.getPoints().get(location2);
            c2.setX(current2.getX()+15);
            c2.setY(current2.getY()+25);
            arr.changeUp();
            card = d.getDeck().get(d.getCurrent());
            repaint();
        }
        if(p1.getLocation() == r.getPoints().size() - 1){
            int x = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Player 1 Wins!!!", JOptionPane.YES_NO_OPTION);//if player1 is on the last spot, they win
            message(x);
        } else if(p2.getLocation() == r.getPoints().size() - 1){
            int t = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Player 2 Wins!!!", JOptionPane.YES_NO_OPTION);
            message(t);
        }
        turn++; //changes whose turn it is (if it's odd, player 1's turn
    }
    
    //handles message box interactions
    public void message(int x){
        if(x == JOptionPane.YES_OPTION){ //checks if they want to play again
            CandyLan h = new CandyLan("CandyLAN"); //starts a new game
            h.d.shuffle(); //shuffles the deck for the new game
        } else {
            System.exit(0); //exits the program when the players are done playing
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
