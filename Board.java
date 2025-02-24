

public class Board{
  private char[][] board;
  private boolean win;
  private boolean loss;
  
  public Board(){
    board = new char[6][7];
    win = false;
    loss = false;
  }

  public boolean isWon(){
    return win;
  }

  public boolean isLost(){
    return loss;
  }
  
  public void setWin(boolean win){
    this.win = win;
  }

  public void setLoss(boolean loss){
    this.loss = loss;
  }

  //method that returns a string of the current board using players counter's chars
  public String getPrintableBoard(char player1, char player2){
    String str = "";
    for(int i=0; i<board.length; i++){
			for(int j=0; j<board[i].length; j++){
				if(board[i][j] == player1){
					str += ("| " + player1 + " ");
				}
				else if(board[i][j] == player2){
					str += ("| " + player2 + " ");
				}
				else{
					str += ("|   ");
				}
			}
			str += ("|" + "\n");
		}
		str += ("  1   2   3   4   5   6   7" + "\n");
    return str;
  }

  //method that places the counter of the player in its desired position while checking whether the move is legal
  public void placeCounter(char player, int position){
		boolean placed = false;
    try{
  		if(player == 'r'){
  			for(int i=board.length-1; i>=0; i--){
  				if(!placed){
  					if(board[i][position-1] == 'y'){
  						// skip
  					}
  					else if(board[i][position-1] != 'r'){
  						board[i][position-1] = 'r';
  						placed = true;
  					}
  				}
  			}
        if(!placed){
          System.out.println("This column is full. You cannot place your counter there! You miss your turn.");
        }
  		}
  		else{
  			for(int i=board.length-1; i>=0; i--){
  				if(!placed){
  					if(board[i][position-1] == 'r'){
  						// skip
  					}
  					else if(board[i][position-1] != 'y'){
  						board[i][position-1] = 'y';
  						placed = true;
  					} 
  				}
  			}
        if(!placed){
          System.out.println("This column is full. You cannot place your counter there! You miss your turn.");
        }
  		}
    }
    catch(ArrayIndexOutOfBoundsException aioobe) {
      System.out.println("Invalid input. You just lost your turn. You should enter a number between 1 and 7!");
    }
	}

  //a method that checks all possible win conditions for a player
  public boolean checkWin(Player player){
    // check horizontal
    boolean won = false;
    int count = 0;
    for(int i=0; i<board.length; i++){
    	for(int j=0; j<board[i].length; j++){
    		if(board[i][j] == player.getCounter()){
    			count = count + 1;
    			if(count >= 4){
    				won = true;
    			}
    	  }
    	  else{
    		  count = 0;
    		}
    	}
      count = 0;
    }
  	// check vertical 
    for(int i=0; i<board[0].length; i++){
    	for(int j=0; j<board.length; j++){
    		if(board[j][i] == player.getCounter()){
    			count = count + 1;
    			if(count >= 4){
    				won = true;
    			}
    		}
    		else{
    			count = 0;
    		}
    	}
      count = 0;
    }
    // check diagonal downward
    for(int i=0; i<board.length-3; i++){
    	for(int j=0; j<board[i].length-3; j++){
    		if(board[i][j] == player.getCounter() && board[i+1][j+1] == player.getCounter() && board[i+2][j+2] == player.getCounter() && board[i+3][j+3] == player.getCounter()){
    			won = true;
    		}
    	}
    }
    // check diagonal upward
    for(int i=3; i<board.length; i++){
    	for(int j=0; j<board[i].length-3; j++){
    		if(board[i][j] == player.getCounter() && board[i-1][j+1] == player.getCounter() && board[i-2][j+2] == player.getCounter() && board[i-3][j+3] == player.getCounter()){
    			won = true;
    		}
    	}
    }
    return won;
  }
}