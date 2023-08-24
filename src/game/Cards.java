/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Armangrewal
 */
public class Cards {
  //Symbolic constants
  public static final int CLUB = 3;
  public static final int DIAMOND = 1;
  public static final int HEART = 0;
  public static final int SPADE = 2;
  
  public int value;
  public int symbol;
  public boolean faceup;
  
  
  public Cards(int value, int symbol, boolean faceup){
      this.value=value;
      this.symbol=symbol;
      this.faceup=faceup;
  }
  
  public boolean getFaceup(){
      return faceup;
  }
  
  public void setFaceup(boolean x){
      this.faceup=x;
  }
  
  public int getValueInt(){
      return value;
  }
  
  public String getSymbol(){
      switch (symbol) {
          case 0:
              return "HEART";
          case 1:
              return "DIAMOND";
          case 2:
              return "SPADE";
          case 3:   
              return "CLUB";
          default:
              throw new IllegalArgumentException("Invalid symbol value: " + symbol);
      }
  }
  
  public String getValueString(){
      switch (value) {
            case 1:
                return "ACE";
            case 11:
                return "JACK";
            case 12:
                return "QUEEN";
            case 13:
                return "KING";
            default:
                return (String.valueOf(value));
        }
  }
  
  @Override
    public String toString(){
     if(faceup==false)
         return "?";
     else{
         return this.getValueString()+" "+"of"+" "+this.getSymbol();
         
     }
    }
    
    
    
}