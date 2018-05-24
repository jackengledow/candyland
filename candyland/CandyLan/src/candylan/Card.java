package candylan;

import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Card {
    private String attr;
    
    public Card(String attr){
        this.attr = attr;
    }
    
    public String getAttr(){
        return this.attr;
    }
    
    public void paintComponent(Graphics c){
        switch(this.attr) {
            case "red": c.setColor(Color.red);
            break;
            case "yellow": c.setColor(Color.yellow);
            break;
            case "blue": c.setColor(Color.blue);
            break;
            case "purple": c.setColor(Color.magenta);
            break;
            case "orange": c.setColor(Color.orange);
            break;
            case "green" : c.setColor(Color.green);
            break;
            default : c.setColor(Color.black);
            break;
            }
        c.fillRect(775,625,150,200);
    }

}
