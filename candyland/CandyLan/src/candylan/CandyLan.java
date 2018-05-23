/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class CandyLan extends JPanel implements MouseListener {

    ArrayList<Rectangle> rects;
    String[] colors = {"red", "yellow", "blue", "purple", "orange", "green"};
    String[] chara = {"Frostine", "Lolly", "Nutt", "Jolly", "Plumpy", "Mint"};
    static Deck d;
    static Board b;
    Rectangle r;
    Circle c1;
    Circle c2;
    Player p1 = new Player();
    Player p2 = new Player();
    private int turn = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CandyLan frame = new CandyLan("CandyLAN");
        d.shuffle();
    }

    public CandyLan(String candyLAN) {
        JFrame frame = new JFrame("CandyLAN");
        frame.setSize(1200, 800);
        rects = new ArrayList<Rectangle>();

        d = new Deck(colors, chara);
        b = new Board(colors);

        r = new Rectangle();
        c1 = new Circle();
        c2 = new Circle(40, 50, Color.white);
        
        Button move = new Button("Draw Card");
        move.setBounds(985, 611, 200, 150);
        move.addMouseListener(this);
        frame.add(move);
        frame.add(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        r.paintComponent(g);
        c1.paintComponent(g);
        c2.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(turn%2 == 1){
            p1.move(b.getSpaces(), d.draw());
            int location1 = p1.getLocation();
            Point current1 = r.getPoints().get(location1);
            c1.setX(current1.getX()+15);
            c1.setY(current1.getY()+5);
            repaint();
        } else {
            p2.move(b.getSpaces(), d.draw());
            int location2 = p2.getLocation();
            Point current2 = r.getPoints().get(location2);
            c2.setX(current2.getX()+15);
            c2.setY(current2.getY()+25);
            repaint();
        }
        if(p1.getLocation() == r.getPoints().size() - 1){
            System.out.println("Player 1 wins!!!");
        } else if(p2.getLocation() == r.getPoints().size() - 1){
            System.out.println("Player 2 wins!!");
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
