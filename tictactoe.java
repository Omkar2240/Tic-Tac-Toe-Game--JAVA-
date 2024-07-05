import java.util.Scanner;
public class tictactoe {
    public static void main(String[] args) {

        // Setting up the board

        char[][] board = new char[3][3];
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                board[row][col] = ' '; 
            }
        }

        // Taking input from the player

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        while(gameOver==false){
            printBoard(board);
            System.out.print("Player "+ player + " enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = player;
                gameOver = haveWon(board, player);
                if(gameOver){
                    System.out.println("Player " + player + " has won: ");
                }else{
                    // if(player == 'X'){
                    //     player = 'O';
                    // }else{
                    //     player = 'X';
                    // }
                    player = (player == 'X') ? 'O' : 'X';  // By inline method
                }
            }else{
                System.out.println("Invalid move..  Try Again!");
            }
        }
        printBoard(board);
    }

    // Check who has Won

    public static boolean  haveWon(char[][] board, char player) {
        // Check for the rows
        for(int row = 0; row < board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        // check for the columns
        for(int col = 0; col < board[0].length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        // for diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player){
            return true;
        }

        // if none of these conditions is true
        return false;
    }

    // For printing the board

    public static void printBoard(char[][] board) {
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                System.out.print(board[row][col]+ " | ");
            }
            System.out.println();
        }
    }
}