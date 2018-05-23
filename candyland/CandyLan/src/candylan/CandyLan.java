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
    Circle c;
    Player p1 = new Player();
    Player p2 = new Player();

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
        c = new Circle();
        
        Player p1 = new Player();
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
        c.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        p1.move(b.getSpaces(), d.draw());
        System.out.println("color: " + d.getDeck().get(d.getCurrent()).getAttr());
        System.out.println("current: " + d.getCurrent());
        System.out.println("location: " + p1.getLocation());
        int location = p1.getLocation();
        Point current = r.getPoints().get(location);
        c.setX(current.getX()+15);
        c.setY(current.getY()+5);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex) {
            Logger.getLogger(CandyLan.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
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
