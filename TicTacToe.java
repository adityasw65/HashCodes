import java.util.*;
class Main 
{
  public static void main(String args[])
  {
    char board[][] = new char[3][3];
    Scanner sc = new Scanner(System.in);
    // System.out.println(a.length);
    for(int row = 0; row < board.length; row++)
    {
      for(int col = 0; col < board[row].length; col++)
      {
        board[row][col] = ' ';
      }
    }
    char player = 'x';
    boolean gameOver = false;
    
    // while loop which run until false
    while(!gameOver)
    {
      printBoard(board);
      System.out.println("Now, Player:"+player+" will enter: ");
      int row = sc.nextInt();
      int col = sc.nextInt();

      if(board[row][col] == ' ')
      {
        board[row][col] = player; // place elements 
        gameOver = haveWon(board, player);
        if(gameOver)
        {
          System.out.print("Player: "+player+" has won the Match..!!");
        }
        else 
        {
          // if(player == 'x')
          //   player = 'o';
          // else
          //   player = 'x';
          player = (player == 'x')? 'o':'x';
        }
      }
      else 
      {
        System.out.println("Invalid input.. Try it again!");
      }
    }
  }

  // printing board
  public static void printBoard(char board[][])
  {
    for(int row = 0; row < board.length; row++)
    {
      for(int col = 0; col < board[row].length; col++)
      {
        System.out.print(board[row][col]+"|");
      }
      System.out.println();
    }
  }
  
  // Winning logic 
  public static boolean haveWon(char board[][], char player)
  {
    // rows are same
    for(int row = 0; row < board.length; row++)
    {
      if(board[row][0] == player && board[row][1] == player && board[row][2] == player)
        return true;
    }
    // columns are same
    for(int col = 0; col < board.length; col++)
    {
      if(board[0][col] == player && board[1][col] == player && board[2][col] == player)
        return true;
    }
    // diagonals are same
    if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
      return true;
    if(board[0][2] == player && board[0][1] == player && board[0][0] == player)
      return true;

    return false;
  }
}


