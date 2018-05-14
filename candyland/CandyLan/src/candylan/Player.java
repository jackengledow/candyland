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
    private int location;
    
    public Player(){
        location = 0;
    }
    
    public void move(ArrayList<String> colors, Card next){
        for(int i = location+1; i<colors.size(); i++){
            if(colors.get(i).equals(next.getAttr())){
                location = i;
                break;
            }
        }
    }
    public int getLocation(){
        return this.location;
    }
}
