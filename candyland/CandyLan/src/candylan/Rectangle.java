/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author jackengledow
 */
public class Rectangle {
    private int x = 25;
    private int y = 25;
    private final int d = 40;
    private ArrayList<Point> points = new ArrayList<Point>();
    private final Color[] colors = {Color.red, Color.yellow, Color.blue, Color.magenta, Color.orange, Color.green};

    public Rectangle(){
        int temp = 0;
        int count = 0;
        while(count<3){
            for(int i = x, j = 0; i<1000; i+=40, j+=1){
                Point p = new Point(i, y + (count*40));
                points.add(p);
                temp = i;
            }
            Point h = new Point(temp, y+(count*40)+40);
            points.add(h);
            for(int e = temp, c = 2; e>=25; e-=40, c+=1){
                Point p = new Point(e, y+(count*40)+80);
                points.add(p);
            }
            Point q = new Point(x, y+(count*40)+120);
            points.add(q);
            this.y = y+120;
            count++;
        }
    }
    
    public void toString(ArrayList<Point> points){
        for(int i = 0; i<points.size(); i++){
            String res = "(" + points.get(i).getX() + ", " + points.get(i).getY() + ")";
            System.out.println(res);
        }
        System.out.println("size: " + points.size());
    }
    
    public ArrayList<Point> getPoints(){
        return this.points;
    }
    public void paintComponent(Graphics g){
        for(int i = 0; i<points.size(); i++){
            Point current = points.get(i);
            g.setColor(colors[i%6]);
            g.fillRect(current.getX(), current.getY(), d, d);
        }
    }
}
