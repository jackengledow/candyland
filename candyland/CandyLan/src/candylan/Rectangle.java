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
    private int x = 25; //initial x coordinate of the board
    private int y = 25; //initial y coordinate of the board
    private final int d = 40; //how big the spaces are
    private ArrayList<Point> points = new ArrayList<Point>(); //list of (x, y) coordinates that keeps track of top left corner of each space
    private final Color[] colors = {Color.red, Color.yellow, Color.blue, Color.magenta, Color.orange, Color.green}; //array of colors used to create the board

    /**
     * adds a point object to points for each rectangle on the board
     */
    public Rectangle(){
        int temp = 0;
        int count = 0;
        while(count<3){ //each loop adds the points for enough spaces to go to the right, down 1, to the left, down one
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
    
    /**
     * prints the all of the point objects in points in (x, y) format
     * @param points: ArrayList of point objects
     */
    public void toString(ArrayList<Point> points){
        //prints out all of the (x, y) coordinates in that form
        for(int i = 0; i<points.size(); i++){
            String res = "(" + points.get(i).getX() + ", " + points.get(i).getY() + ")";
            System.out.println(res);
        }
        System.out.println("size: " + points.size()); //prints how many points there are in the list
    }
    
    public ArrayList<Point> getPoints(){
        return this.points; //returns array list of points
    }

    /**
     * paints a graphical representation of the boards
     * @param g: graphics component used to paint
     */
    public void paintComponent(Graphics g){
        for(int i = 0; i<points.size(); i++){ //loops through all of the points
            Point current = points.get(i);
            g.setColor(colors[i%6]); //gets all of the colors
            g.fillRect(current.getX(), current.getY(), d, d); //paints a rectangle at that point with that color
        }
    }
}
