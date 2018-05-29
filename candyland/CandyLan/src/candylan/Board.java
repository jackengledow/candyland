/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Board {
    private ArrayList<String> spaces  = new ArrayList<String>(); //new array list to hold the list of colors used
    
    public Board(String[] colors){
        for(int i = 0; i<156; i++){
            spaces.add(colors[i%6]); //loops through the colors and adds them all to a list
        }
    }
    
    /**
     *returns the colors of the board as an arrayList of Strings
     */
    public ArrayList<String> getSpaces(){
        return this.spaces; //allows us to get 
    }
    public void print(){
        System.out.println("");
        String res = "";
        for(String c: spaces){ //loops through each of the spaces and adds them to a string
            res += c + " ";
        }
        System.out.print(res); //prints the string of colors
    }
}
