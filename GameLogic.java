public class GameLogic{

  private Board board;
  private Player player1;
  private Player computer;

  public GameLogic(){
    board = new Board();
    player1 = new Player('r');
    computer = new Player('y');
  }

  public void playGame(){
    System.out.println(getInstructions());
		System.out.println(board.getPrintableBoard(player1.getCounter(), computer.getCounter()));
		
		while(!board.isWon() || !board.isLost()){
  		// player 1
      int turn = 0;
  		boolean hasWon = false;
       while(!hasWon || turn >= 42){
        //getting player's input, placing it on the board, updating and pritning the board and checking if he has won.
        board.placeCounter(player1.getCounter(),player1.getMove());
        hasWon = board.checkWin(player1);
    		System.out.println(board.getPrintableBoard(player1.getCounter(), computer.getCounter()));
        turn++;
    		if(hasWon){
    			board.setWin(true);
    		} 
        else{
    			//receiving computers's move, placing it on the board, updating and pritning the board and checking if it has won.
    			board.placeCounter(computer.getCounter(),computer.getComputerMove());
    			hasWon = board.checkWin(computer);
    			System.out.println(board.getPrintableBoard(player1.getCounter(), computer.getCounter()));
          turn++;
    			if(hasWon){
    				board.setLoss(true);
    			}
        }
  		}
      //checking if the game has been won, lost or drawn
      if(board.isWon()){
        System.out.println("You Have Won!!!");
      }
      else if(board.isLost()){
        System.out.println("You Have Lost! Computer won!");
      }
      else if(turn == 42){
        System.out.println("It's a draw!");
      }
    }
  }


  //instructions String method
  private static String getInstructions(){
    String instructions = "";
    instructions += ("Welcome to Connect 4" + "\n");
		instructions += ("There are 2 players red and yellow" + "\n");
		instructions += ("Player 1 is Red, Computer is Yellow" + "\n");
		instructions += ("To play the game type in the number of the column (1-7) you want to drop your counter in" + "\n");
		instructions += ("A player wins by connecting 4 counters in a row - vertically, horizontally or diagonally" + "\n");
		instructions += ("" + "\n");
    return instructions;
  }
}
