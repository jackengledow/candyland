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
public class Circle  {
    private int r = 10; //radius
    private int x; //x coordinate of circle
    private int y; //y coordinate of circle
    private Color color; //color of circle
    
    public Circle(int x, int y, Color c){ //initializes x, y, and color of circle
        this.y = y;
        this.x = x;
        this.color = c;
    }
    public Circle(int x, int y, Color c, int r){ //another constructor that also changes size
        this.y = y;
        this.x = x;
        this.color = c;
        this.r = r;
    }
    public Circle(){ //default constructor
        this.y = 30;
        this.x = 40;
        this.color = Color.black;
    }
    public int getR(){ //returns the size
        return this.r;
    }
    public int getX(){ //returns x coordinate
        return this.x;
    }
    public int getY(){ //returns y coordinate
        return this.y;
    }
    public void setR(int r){ //sets size of circle
        this.r = r;
    }
    public void setX(int x){ //sets x coordinate
        this.x = x;
    }
    public void setY(int y){ //sets y coordinate
        this.y = y;
    }
    
    public void paintComponent(Graphics g){ //paints the circle
        g.setColor(color);
        g.fillOval(x, y, r, r);
    }
}
