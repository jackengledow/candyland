/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Owner
 */
public class CandyLan extends JPanel {

    ArrayList<Rectangle> rects;
    String[] colors = {"red", "yellow", "blue", "purple", "orange", "green"};
    String[] chara = {"Frostine", "Lolly", "Nutt", "Jolly", "Plumpy", "Mint"};
    static Deck d;
    static Board b;
    Rectangle r;
    Circle c;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CandyLan frame = new CandyLan("CandyLAN");
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
        Button move = new Button("Move");
        move.setBounds(985, 611, 200, 150);
        //move.processActionEvent();
        frame.add(move);
        frame.add(this);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        r.paintComponent(g);
        c.paintComponent(g);
    }

}
