/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import java.util.Scanner;

/**
 *
 * @author Armangrewal
 */
public class SimpleUI implements UserInterface{
    
    private BlackjackGame game;
    private Scanner s=new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game=game;
       
    }

    @Override
    public void display() {
        System.out.println("The House Has:\n "+ game.getHouseCards());
        System.out.println("You Have: \n"+ game.getPlayerCards()+"\n\n");
    }

    @Override
    public boolean hitMe() {
        System.out.println("Would You Like Another Card? Type Y or N");
        String result = s.nextLine();
        return (("Y".equals(result)) || ("y").equals(result));
    }

    @Override
    public void gameOver() {
        int yourscore = game.score(game.getPlayerCards());   
        int housescore = game.score(game.getHouseCards()); 
        String winner;
        if(yourscore >= 22 || (yourscore <housescore && housescore <= 21)){  
            winner = "The House is the winner";
        }
        else if(yourscore==housescore) {
            winner = "Push between House and Player";  
        }
        else{
            winner = "You are the winner!";  
        }
        System.out.println("The game is now over!\n You ended with\n" + game.getPlayerCards()+ "with a total score of " 
                + yourscore + "\n\nThe House ended with\n" + game.getHouseCards() 
                + " with a total score of "  + housescore + "\n\n" + winner);
    }
    
    }