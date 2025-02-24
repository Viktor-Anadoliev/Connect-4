import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Player{

  private char counter;
  private BufferedReader input;

  public Player(char counter){
    this.counter = counter;
    input = new BufferedReader(new InputStreamReader(System.in));
  }

  public char getCounter(){
    return counter;
  }

  public void setCounter(char counter){
    this.counter = counter;
  }

  //method that returns the move of the player as an int
  public int getMove(){
    try{
      String userInput = getUserInput();
    	int move = Integer.parseInt(userInput);
      return move;
    }
    catch(NumberFormatException nfe) {

    }
    return -1;
  }

  //method that returns a random generated move of the computer as an int
  public int getComputerMove(){
    Random rand = new Random();
    int randomMove = rand.nextInt(7) + 1;
    System.out.println("Computer's turn: ");
    return randomMove;
  }

  //method that parses users input to an integer
  private String getUserInput(){
    String toReturn = null;
	 try{			
	   toReturn = input.readLine();
	 }
	 catch(Exception e){
	   System.out.println(e);
	 }
	 return toReturn;
  }
}