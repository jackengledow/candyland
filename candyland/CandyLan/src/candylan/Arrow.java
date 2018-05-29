/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Graphics;

/**
 *
 * @author jackengledow
 */
public class Arrow {
    private int[] x = new int[3]; //array of x coordnates used to paint arrow
    private int[] y = new int[3]; //array of y coordinates
    
    public Arrow(int[] x, int[] y){
        this.x = x;
        this.y = y;
    }
    
    public void changeDown(){ //increases all y values by 75, moving it down by 75 pixels
        for(int i = 0; i<this.y.length; i++){
            this.y[i] = this.y[i]+75;
        }
    }
    
    public void changeUp(){ //decreases all y values by 75, moving it up by 75 pixels
        for(int i = 0; i<this.y.length; i++){
            this.y[i] = this.y[i]-75;
        }
    }
    
    public void paintComponent(Graphics g){
        g.fillPolygon(x, y, 3); //paints indicator arrow
    }
}
