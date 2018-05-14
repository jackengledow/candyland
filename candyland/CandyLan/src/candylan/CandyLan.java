/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Owner
 */
public class CandyLan {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        int x = 25, y = 25;
        ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
        String[] colors = {"red", "green", "blue", "yellow", "orange", "purple"};
        String[] chara = {"Frostine", "Lolly", "Nutt", "Jolly", "Plumpy", "Mint"};
        Deck d = new Deck(colors, chara);
        Board b = new Board(colors);
        
        
        JFrame frame = new JFrame("CandyLAN");
        frame.setSize(1000, 800);
        Rectangle r = new Rectangle();
        Circle c = new Circle();
        frame.getContentPane().add(c);
        frame.getContentPane().add(r);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
