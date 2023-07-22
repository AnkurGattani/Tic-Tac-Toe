import java.util.*;

class TicTacToe {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        char[][] board = new char[3][3]; // initialization of the Board
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = ' ';
            }
        }

        char player = 'X'; // current player
        boolean gameOver = false;
        int turns = 0;

        while (!gameOver) {
            printBoard(board); // prints the Board before player's input
            if (++turns > 9) {
                System.out.println("Board Full. Game ended in DRAW!");
                break;
            }

            System.out.print("Player " + player + " enter your move: "); // player input
            int row = in.nextInt(); // row index
            int col = in.nextInt(); // column index

            if (row < 3 && col < 3 && board[row][col] == ' ') { // the move is valid only if the grid is empty
                board[row][col] = player;
                if (checkIfPlayerHasWon(board, player)) {
                    System.out.println("Player " + player + " Wins!");
                    gameOver = true; // game over
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // switch the players for the next turn
                }

            } else {
                System.out.println("Invalid move. Try again!");
            }
        }
    }

    private static boolean checkIfPlayerHasWon(char[][] board, char player) {

        for (int row = 0; row < board.length; row++) { // check for row-wise win

            if (board[row][0] == player && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }

        for (int col = 0; col < board.length; col++) { // check for column-wise win

            if (board[0][col] == player && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }

        if (board[0][0] == player && board[0][0] == board[1][1] && board[1][1] == board[2][2]) { // check for principal
                                                                                                 // diagonal win
            return true;
        }
        if (board[0][2] == player && board[0][2] == board[1][1] && board[1][1] == board[2][0]) { // check for
                                                                                                 // non-pricipal
                                                                                                 // diagonal win
            return true;
        }
        return false;
    }

    public static void printBoard(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println();
        }
    }
}