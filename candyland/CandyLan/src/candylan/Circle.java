/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author jackengledow
 */
public class Circle extends Canvas{
    private int r = 10;
    private int x = 10;
    private int y = 10;
    
    public Circle(){}
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
    
    public void paint(Graphics g){
        g.setColor(Color.BLACK);
        g.fillOval(x, y, r, r);
    }
}
