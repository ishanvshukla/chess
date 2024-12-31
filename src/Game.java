//Written by Jason Jiang and Ishan Shukla

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Fen.load("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR", board);
//        Fen.load("8/1p2P3/8/3p2P1/1P6/5p2/3P4/8", board);
        System.out.println(board);
        Scanner input = new Scanner(System.in);
        int move = 0;
        while (!board.isGameOver()) {
            if (move % 2 == 0) {
                System.out.println("It is currently white's turn to play.");
            } else {
                System.out.println("It is currently black's turn to play.");
            }
            System.out.println("What is your move? (format: [start row] [start col] [end row] [end col])");
            String[] newMove = input.nextLine().split(" ");
            if (board.getPiece(Integer.parseInt(newMove[0]), Integer.parseInt(newMove[1])).getIsBlack() == (move % 2 == 0)) {
                System.out.println(board);
                continue;
            }
            board.movePiece(Integer.parseInt(newMove[0]), Integer.parseInt(newMove[1]), Integer.parseInt(newMove[2]), Integer.parseInt(newMove[3]));
            System.out.println(board);
            move++;
        }
        System.out.println("Game Over!");
    }
}