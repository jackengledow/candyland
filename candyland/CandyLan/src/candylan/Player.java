/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.util.ArrayList;

/**
 *
 * @author jackengledow
 */
public class Player {
    private int location; //where the player is on the board
    
    public Player(){
        location = 0; //default location is 0, or first spot on the board
    }
    
    /**
     * Looks for the space on the board that is the same as the card, and updates the players location
     * to the position of the color on the board
     * @param colors: arrayList of all of the board spaces, the strings are the color that the space is
     * @param next: the card that was drawn, used to find the next color that the player should move to
     */
    public void move(ArrayList<String> colors, Card next){
        for(int i = location+1; i<colors.size(); i++){ //loops through the spaces until it finds the color matching that of the card
            if(colors.get(i).equals(next.getAttr())){
                location = i; //sets location of player to location of that color on the board
                break; //breaks so that it only finds the first instance
            }
        }
    }
    
    public int getLocation(){
        return this.location; //returns the current location of the player
    }
}
