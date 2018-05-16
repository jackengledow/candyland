/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package candylan;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Owner
 */
public class Board {
    private ArrayList<String> spaces  = new ArrayList<String>();
    ArrayList<String> colors = new ArrayList<String>();
    
    public Board(String[] colors){
        for(int i = 0; i<21; i++){
            for(String c: colors){
                spaces.add(c);
                if(i == 0){
                    for(String d: colors){
                        this.colors.add(d);
                    }
                }
            }
        }
    }
    
    public ArrayList<String> getSpaces(){
        return this.spaces;
    }
    public void print(){
        System.out.println("");
        String res = "";
        for(String c: spaces){
            res += c + " ";
        }
        System.out.print(res);
    }
}
