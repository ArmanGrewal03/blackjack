/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Armangrewal
 */
public class BlackjackGame {
    
    private CardPile houseCards;
    private CardPile playerCards;
    private CardPile deck;
    private boolean HouseDone;
    private boolean PlayerDone;
    private UserInterface ui;
    
    public BlackjackGame(UserInterface x){
        this.ui=x;
        ui.setGame(this);
        houseCards = new CardPile();
        deck = new CardPile();
        playerCards = new CardPile();
        HouseDone = false;
        PlayerDone = false;
        
        for(int i = 1; i < 14; i++) {
            for(int j = 0; j < 4; j++) {
                deck.add(new Cards(i, j, true));
            }
        }
        
    }
    
    public void start(){
        Cards x = deck.removeCard();
        x.setFaceup(false);
        houseCards.add(x);
        houseCards.add(deck.removeCard());
        playerCards.add(deck.removeCard());
        playerCards.add(deck.removeCard());
        ui.display();
    }
    
    public void play(){
        while (!HouseDone || !PlayerDone) {
      while (!PlayerDone) {
        if (ui.hitMe()) {
          playerCards.add(deck.removeCard());
          ui.display();
          if (score(playerCards) >= 21) {//The player can keep saying yes until their score is greatr than or equal to 21, and then the game ends
              PlayerDone = true;
          }
        } 
        else {
          PlayerDone = true;
        }
      }
       if (!HouseDone) {
        if (score(houseCards) <= 17) {
          houseCards.add(deck.removeCard());
          ui.display();
        } else {
          HouseDone = true;
        }
        //This controls when the game is finished. The house keeps playing until the score is greater than 17.
      }
    }
    }
    
    public int score(CardPile p){
        int score = 0; //Makes the score 0
    for(int i=0;i<(p.getCards().size());i++){  
        if(p.getCards().get(i).getValueInt() <= 10){ 
            score += p.getCards().get(i).getValueInt();
        }
        if(13 >= p.getCards().get(i).getValueInt() && p.getCards().get(i).getValueInt()>= 11){ 
            score += 10;
            
        }
    }
    return (score);
    }
    
    public void end() {
    getHouseCards().getCards().get(0).setFaceup(true);
    ui.gameOver();
    }
    
    public CardPile getHouseCards(){
        return houseCards;
    }
    
    public CardPile getPlayerCards(){
        return playerCards;
    }
    
    public static void main(String[] args) {
    BlackjackGame game = new BlackjackGame(new SimpleUI());
    game.start();
    game.play();
    game.end();
  }
    
    
    
    
}