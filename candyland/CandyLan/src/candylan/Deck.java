package candylan;


import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Deck {
    private ArrayList<Card> deck = new ArrayList<Card>();
    private int current = 0;
    
    public Deck(String[] colors, String[] charas){
        for(String c : colors){
            for(int i = 0; i<10; i++){
                Card card = new Card(c);
                deck.add(card);
            }
        }
        /*for(String d: charas){
            Card bard = new Card(d);
            deck.add(bard);
        }*/
    }
    
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card draw(){
        if(current == 60){
            current = 0;
            this.shuffle();
        }
        current++;
        return deck.get(current);
    }
    public int getCurrent(){
        return this.current;
    }
    public void setCurrent(int index){
        this.current = index;
    }
    public ArrayList<Card> getDeck(){
        return this.deck;
    }
    public void print(){
        System.out.println("");
        String res = "";
        for(Card c: deck){
            res += c.getAttr() + " ";
        }
        System.out.print(res);
    }
}
