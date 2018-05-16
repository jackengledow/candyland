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
    private int r = 10;
    private int x;
    private int y;
    
    public Circle(int x, int y){
        this.y = y;
        this.x = x;
    }
    public Circle(){
        this.y = 30;
        this.x = 40;
    }
    public int getR(){
        return this.r;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setR(int r){
        this.r = r;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, r, r);
    }
}
