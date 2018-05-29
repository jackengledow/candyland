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
    private ArrayList<Card> deck = new ArrayList<Card>(); //arrayList of cards
    private int current = 0; //tracks where you are in the deck
    
    public Deck(String[] colors){
        for(String c : colors){
            for(int i = 0; i<10; i++){
                Card card = new Card(c); //makes ten cards of each color and adds them to the deck
                deck.add(card);
            }
        }
    }
    
    public void shuffle(){ //randomizes the deck
        Collections.shuffle(deck);
    }
    public Card draw(){ //returns the next card in the deck
        if(current == 59){
            current = 0; //if deck is empty, reset and shuffle the deck
            this.shuffle();
        }
        current++;
        return deck.get(current);
    }
    public int getCurrent(){ //returns what location you are currently in in the deck
        return this.current;
    }
    public ArrayList<Card> getDeck(){
        return this.deck; //returns all of the cards in an arrayList
    }
    public void print(){ //prints the value of each card in the deck as a string
        System.out.println("");
        String res = "";
        for(Card c: deck){
            res += c.getAttr() + " ";
        }
        System.out.print(res);
    }
}
