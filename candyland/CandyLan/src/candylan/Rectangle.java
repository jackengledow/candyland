/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jackengledow
 */
public class Rectangle {
    private int x = 25;
    private int y = 25;
    private final int d = 40;
    private final Color[] colors = {Color.red, Color.yellow, Color.blue, Color.magenta, Color.orange, Color.green};

    
    public void paintComponent(Graphics g){
        int temp = 0;
        for(int i = x, j = 0; i<1000; i+=40, j+=1){
            Color c = colors[j%6];
            g.setColor(c);
            g.fillRect(i, y, d, d);
            temp = i;
        }
        g.setColor(colors[1]);
        g.fillRect(temp, 65, d, d);
        for(int e = temp, c = 2; e>=25; e-=40, c+=1){
            Color t = colors[c%6];
            g.setColor(t);
            g.fillRect(e, y+80, d, d);
        }
    }
}
