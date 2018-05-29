/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

/**
 *
 * @author jackengledow
 */
public class Point {
    private int x, y; //declares x, y coordinates
    
    public Point(int x, int y){ //sets the x, y coordinates
        this.x = x;
        this.y = y;
    }
    
    public int getX(){ //returns the x coordinate
        return this.x;
    }
    
    public int getY(){ //returns y coordinate
        return this.y;
    }
}
