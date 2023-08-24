/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.ArrayList;

/**
 *
 * @author Armangrewal
 */
public class CardPile {
    ArrayList <Cards> cardPile;

    
    public CardPile() {
        ArrayList<Cards> cardPile = new  ArrayList<Cards>(); 
        this.cardPile = cardPile;
    }
    
    public void add(Cards card) { 
        cardPile.add(card);
    }
    
    public Cards removeCard(){
        int random = (int )(Math.random() * (cardPile.size() - 1)); 
        Cards removed = (cardPile.remove(random));
        return removed; 
    }
    
    public ArrayList<Cards> getCards() {
        return cardPile;
    }
    
      @Override
    public String toString() {
        ArrayList<String> temp=new ArrayList<String>();
        String list = ""; 
        String element;
        for(int i=0;i<(cardPile.size());i++){     
           element = (cardPile.get(i)).toString();
           temp.add(element);
           temp.add(" and ");
        }
        for(int i=0;i<(temp.size()-1);i++){
            list=list+temp.get(i);
        }
        return list;
    }
    
    
    
    
}