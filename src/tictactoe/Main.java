package tictactoe;

import java.util.Scanner;

public class Main {

    private static char[][] boardState = new char[3][3];
    private static boolean gameOver = false;
    private static char player = 'X';

    public static void main(String[] args) {

        gameSetup();
        do {
            printBoard();
            makeAMove();
            checkGameCondition();
        } while (!gameOver);
    }

    public static void printBoard() {

        System.out.println("---------");
        System.out.println("| " + boardState[0][0] + " " + boardState[0][1] + " " + boardState[0][2] + " |");
        System.out.println("| " + boardState[1][0] + " " + boardState[1][1] + " " + boardState[1][2] + " |");
        System.out.println("| " + boardState[2][0] + " " + boardState[2][1] + " " + boardState[2][2] + " |");
        System.out.println("---------");
    }

     public static void gameSetup() {

        char[][] startingArray = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = ' ';

            }
        }

    }

    public static void checkGameCondition() {

        boolean xWins = false;
        boolean oWins = false;

        //Sets xWins to true if there are three X's in a row.
        if (boardState[0][0] == 'X') {
            if ((boardState[0][1] == 'X' && boardState[0][2] == 'X') ||
                    (boardState[1][0] == 'X' && boardState[2][0] == 'X') ||
                    (boardState[1][1] == 'X' && boardState[2][2] == 'X')) {
                xWins = true;
            }
        }
        if (boardState[1][1] == 'X') {
            if ((boardState[1][0] == 'X' && boardState[1][2] == 'X') ||
                    (boardState[0][1] == 'X' && boardState[2][1] == 'X') ||
                    (boardState[0][2] == 'X' && boardState[2][0] == 'X')) {
                xWins = true;
            }
        }
        if (boardState[2][2] == 'X') {
            if ((boardState[2][0] == 'X' && boardState[2][1] == 'X') ||
                    (boardState[0][2] == 'X' && boardState[1][2] == 'X')) {
                xWins = true;
            }
        }

        //Sets oWins to true if there are three O's in a row.
        if (boardState[0][0] == 'O') {
            if ((boardState[0][1] == 'O' && boardState[0][2] == 'O') ||
                    (boardState[1][0] == 'O' && boardState[2][0] == 'O') ||
                    (boardState[1][1] == 'O' && boardState[2][2] == 'O')) {
                oWins = true;
            }
        }
        if (boardState[1][1] == 'O') {
            if ((boardState[1][0] == 'O' && boardState[1][2] == 'O') ||
                    (boardState[0][1] == 'O' && boardState[2][1] == 'O') ||
                    (boardState[0][2] == 'O' && boardState[2][0] == 'O')) {
                oWins = true;
            }
        }
        if (boardState[2][2] == 'O') {
            if ((boardState[2][0] == 'O' && boardState[2][1] == 'O') ||
                    (boardState[0][2] == 'O' && boardState[1][2] == 'O')) {
                oWins = true;
            }
        }

        //Check for an appropriate number of each symbol.
        int xCount = 0;
        int oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardState[i][j] == 'X') {
                    xCount++;
                } else if (boardState[i][j] == 'O') {
                    oCount++;
                }
            }
        }

        if (xWins) {
            printBoard();
            System.out.println("X wins");
            gameOver = true;
        } else if (oWins) {
            printBoard();
            System.out.println("O wins");
            gameOver = true;
        } else if (xCount + oCount == 9) {
            printBoard();
            System.out.println("Draw");
            gameOver = true;
        }

    }

    public static void makeAMove() {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter the coordinates: ");
            char[] input = scanner.nextLine().toCharArray();

            if (!Character.isDigit(input[0]) || !Character.isDigit(input[2])) {
                System.out.println("You should enter numbers!");
                continue;
            }
            int a = Character.getNumericValue(input[0]);
            int b = Character.getNumericValue(input[2]);


            if (a > 3 || b > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (boardState[a - 1][b - 1] == 'X' || boardState[a - 1][b - 1] == 'O') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            boardState[a - 1][b - 1] = player;
            if (player == 'X'){
                player = 'O';
            } else {
                player = 'X';
            }
            break;


        } while (true);


    }
}
