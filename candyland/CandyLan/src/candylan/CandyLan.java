/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.*;
import java.awt.event.*;
/*import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;*/
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/*import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;*/
import javax.swing.*;

/**
 *
 * @author Owner
 */
public class CandyLan extends JPanel implements MouseListener {

    String[] colors = {"red", "yellow", "blue", "purple", "orange", "green"}; // colors used to create the board and keep track of players locations
    String[] chara = {"Frostine", "Lolly", "Nutt", "Jolly", "Plumpy", "Mint"};// same thing as above but with characters
    static Deck d; //array list of cards used to move player along the board (cards hold value of either character or color
    Board b; //board is array list of strings that is the same as displayed to keep track of player location
    Rectangle r; //graphical representation of the board (includes all spaces)
    Circle c1; //graphical representation of where the players are
    Circle c2;
    Player p1 = new Player(); //allows us to keep track of where the player is on the board
    Player p2 = new Player();
    private int turn = 1; //tells us who's turn it is (increments everytime you move
    static Circle indicator1 = new Circle(215, 617, Color.black, 25); //shows which circle represents which player (indicates)
    static Circle indicator2 = new Circle(215, 692, Color.white, 25); //instantiates location, color, and size of circle

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CandyLan frame = new CandyLan("CandyLAN"); //starts a new game
        d.shuffle(); //shuffles the deck
    }

    public CandyLan(String candyLAN) {
        JFrame frame = new JFrame("CandyLAN"); //frame to add graphical components
        frame.setSize(1200, 800); //sets size of the window

        d = new Deck(colors, chara); //creates a new deck with the colors and characters declared before
        b = new Board(colors); //creates a new board with the colors

        r = new Rectangle(); //creates the board
        c1 = new Circle(); //creates the players pieces on the board
        c2 = new Circle(40, 50, Color.white);
        
        
        Font font = new Font("SansSerif", Font.PLAIN, 40); //makes the font that is used on the button and indicator fields
        
        Button move = new Button("Draw Card"); //creates button that allows the players to be moved
        move.setFont(font); //sets the buttons font to the one created above
        move.setBounds(985, 611, 200, 150); //tells where and how large the button is
        move.addMouseListener(this); //adds a mouse listener to the button so that we can do something when it is clicked
       
        JTextField field1 = new JTextField("Player 1:"); //creates the first textbox to tell the players which circle is which player
        field1.setBorder(null); //takes away the border
        field1.setEditable(false); //the user can not edit the text
        field1.setBounds(50, 600, 155, 50); //tells where and how large the textbox is
        field1.setFont(font); //sets the font to the one created above
        
        JTextField field2 = new JTextField("Player 2:"); //creates second textbox
        field2.setBorder(null);
        field2.setEditable(false);
        field2.setBounds(50, 675, 155, 50);
        field2.setFont(font);
        
        //adds the textboxes, button, and itself to the frame
        frame.add(field1);
        frame.add(field2);
        frame.add(move);
        frame.add(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //when you hit the x it closes the program
        frame.setVisible(true); //makes it visible
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        r.paintComponent(g); //paints the board
        c1.paintComponent(g); //paints the pieces
        c2.paintComponent(g);
        indicator1.paintComponent(g); //paints the indicators
        indicator2.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(turn%2 == 1){ //if turn is odd, player one's turn
            p1.move(b.getSpaces(), d.draw()); //move the player to the next spot that is the same color as the card
            int location1 = p1.getLocation(); //gets index of where player is on the board
            Point current1 = r.getPoints().get(location1); //gets coordinates of space that the player is moving to
            c1.setX(current1.getX()+15); // moves the player to that location
            c1.setY(current1.getY()+5);
            repaint(); //repaints the board with new coordinates
        } else { //if turn is even, do the same thing for player 2
            p2.move(b.getSpaces(), d.draw());
            int location2 = p2.getLocation();
            Point current2 = r.getPoints().get(location2);
            c2.setX(current2.getX()+15);
            c2.setY(current2.getY()+25);
            repaint();
        }
        /*if(p1.getLocation() == r.getPoints().size() - 1){
            JOptionPane.showMessageDialog(null, "Player 1 Wins!!!!!"); //if player1 is on the last spot, they win
        } else */if(p2.getLocation() == r.getPoints().size() - 1){
            JOptionPane.showMessageDialog(null, "Player 2 Wins!!!!!"); //if player2 is on the last spot, the win
        }
        turn++;
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
