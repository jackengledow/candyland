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
    private String attr; //color that the card is
    
    public Card(String attr){
        this.attr = attr; //sets the color based on an input
    }
    
    public String getAttr(){
        return this.attr; //returns the color of the card
    }
    
    public void paintComponent(Graphics c){ //paints the color of the card by checking its attribute
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
