package Game;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

class Main {
    static void display() {
        System.out.println("Welcome in chines checkers Game");
        System.out.println("please chose Your level of difficulty");
        System.out.println("1-Easy");
        System.out.println("2-Medium");
        System.out.println("3-Hard");
    }

    static void displayAvailble(ArrayList<Integer> moves) {
        for (int i = 0; i < moves.size(); i += 2) {
            System.out.println("x->" + moves.get(i) + " Y->" + moves.get(i + 1));
        }
    }

    static Moves myMove = new Moves();
    static createBoard Board = new createBoard();
    static Players players = new Players();
    static AlphaBeta Ai = new AlphaBeta();

    public static void updateBoard(char[][] board, int MyRow, int MyColum, int MyNewRow, int MyNewColum) {
        Board.displayBoard();
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] = 'O';
    }

    public static void main(String[] args) {
        display();
        Scanner sc = new Scanner(System.in);    
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("You are in the Easy level!");
                Board.displayBoard();
                while (true) {
                    players.displayHumanMoves();
                    System.out.println("Enter your X");
                    int xP = sc.nextInt();
                    System.out.println("Enter your Y");
                    int yP = sc.nextInt();
                    ArrayList<Integer> moves = myMove.AllAvailableMoves(xP, yP, Board.getBoard());
                    if (moves.size() == 0) {
                        System.out.println("please add new x & Y new available Moves");
                    } else {
                        displayAvailble(moves);
                        System.out.println("Choose your X");
                        int xC = sc.nextInt();
                        System.out.println("Choose your Y");
                        int yC = sc.nextInt();
                        updateBoard(Board.getBoard(), xP, yP, xC, yC);
                        players.updatePlayer(1, xP, yP, xC, yC);
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        System.out.println("Computer Turn");
                        char[][] tempBoard = new char[17][];
                        for (int i = 0; i < 17; i++) {
                            tempBoard[i] = Board.getBoard()[i].clone();
                        }
                        ArrayList<Integer> arr = new ArrayList<Integer>();

                        ArrayList<Integer> is = AlphaBeta.alphaBeta(tempBoard, 1, players.getComputer(), players.getHuman(),
                                true, Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
                        System.out.println(is);
                        updateBoard(Board.getBoard(), is.get(0), is.get(1), is.get(2), is.get(3));
                        players.updatePlayer(6, is.get(0), is.get(1), is.get(2), is.get(3));
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        if (Main.myMove.checkWinner(Board.getBoard()) == 1) {
                            System.out.println("The Human is the winner");
                            break;
                        } else if ((Main.myMove.checkWinner(Board.getBoard()) == 2)) {
                            System.out.println("The Computer is the winner");
                            break;
                        }
                    }
                }
                break;
            case 2:
                System.out.println("You are in the Medium level!");
                Board.displayBoard();
                while (true) {
                    players.displayHumanMoves();
                    System.out.println("Enter your X");
                    int xP = sc.nextInt();
                    System.out.println("Enter your Y");
                    int yP = sc.nextInt();
                    ArrayList<Integer> moves = myMove.AllAvailableMoves(xP, yP, Board.getBoard());
                    if (moves.size() == 0) {
                        System.out.println("please add new x & Y new available Moves");
                    } else {
                        displayAvailble(moves);
                        System.out.println("Choose your X");
                        int xC = sc.nextInt();
                        System.out.println("Choose your Y");
                        int yC = sc.nextInt();
                        updateBoard(Board.getBoard(), xP, yP, xC, yC);
                        players.updatePlayer(1, xP, yP, xC, yC);
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        System.out.println("Computer Turn");
                        char[][] tempBoard = new char[17][];
                        for (int i = 0; i < 17; i++) {
                            tempBoard[i] = Board.getBoard()[i].clone();
                        }
                        ArrayList<Integer> arr = new ArrayList<Integer>();

                        ArrayList<Integer> is = AlphaBeta.alphaBeta(tempBoard, 1, players.getComputer(), players.getHuman(),
                                true, Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
                        System.out.println(is);
                        updateBoard(Board.getBoard(), is.get(0), is.get(1), is.get(2), is.get(3));
                        players.updatePlayer(6, is.get(0), is.get(1), is.get(2), is.get(3));
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        if (Main.myMove.checkWinner(Board.getBoard()) == 1) {
                            System.out.println("The Human is the winner");
                            break;
                        } else if ((Main.myMove.checkWinner(Board.getBoard()) == 2)) {
                            System.out.println("The Computer is the winner");
                            break;
                        }
                    }
                }
                break;
            case 3:
                System.out.println("You are in the Hard level!");
                Board.displayBoard();
                while (true) {
                    players.displayHumanMoves();
                    System.out.println("Enter your X");
                    int xP = sc.nextInt();
                    System.out.println("Enter your Y");
                    int yP = sc.nextInt();
                    ArrayList<Integer> moves = myMove.AllAvailableMoves(xP, yP, Board.getBoard());
                    if (moves.size() == 0) {
                        System.out.println("please add new x & Y new available Moves");
                    } else {
                        displayAvailble(moves);
                        System.out.println("Choose your X");
                        int xC = sc.nextInt();
                        System.out.println("Choose your Y");
                        int yC = sc.nextInt();
                        updateBoard(Board.getBoard(), xP, yP, xC, yC);
                        players.updatePlayer(1, xP, yP, xC, yC);
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        System.out.println("Computer Turn");
                        char[][] tempBoard = new char[17][];
                        for (int i = 0; i < 17; i++) {
                            tempBoard[i] = Board.getBoard()[i].clone();
                        }
                        ArrayList<Integer> arr = new ArrayList<Integer>();

                        ArrayList<Integer> is = AlphaBeta.alphaBeta(tempBoard, 1, players.getComputer(), players.getHuman(),
                                true, Integer.MIN_VALUE, Integer.MAX_VALUE, arr);
                        System.out.println(is);
                        updateBoard(Board.getBoard(), is.get(0), is.get(1), is.get(2), is.get(3));
                        players.updatePlayer(6, is.get(0), is.get(1), is.get(2), is.get(3));
                        System.out.println("Updated Board");
                        Board.displayBoard();
                        if (Main.myMove.checkWinner(Board.getBoard()) == 1) {
                            System.out.println("The Human is the winner");
                            break;
                        } else if ((Main.myMove.checkWinner(Board.getBoard()) == 2)) {
                            System.out.println("The Computer is the winner");
                            break;
                        }
                    }
                }
                break;
        }
        System.out.println("End Game Thank you for playing");
    }
}
