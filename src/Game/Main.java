package Game;

import java.util.ArrayList;

class Main {
    static Moves myMove = new Moves();
    static createBoard Board = new createBoard();
    static Players players=new Players();
    static AlphaBeta Ai=new AlphaBeta();
    public static void updateBoard(char[][] board, int MyRow, int MyColum, int MyNewRow, int MyNewColum) {
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] = 'O';
    }
    public static void main(String[] args) {
        Board.displayBoard();
       // players.displayHumanMoves();
        //char [][]tempBoard=Board.getBoard();
        char[][] tempBoard = new char[17][];
        for (int i = 0; i < 17; i++) {
            tempBoard[i] = Board.getBoard()[i].clone();
        }



        ArrayList<Integer>arr =new ArrayList<Integer>();

        ArrayList<Integer> is= AlphaBeta.alphaBeta(tempBoard,1,players.getComputer(),players.getHuman(),
                true,Integer.MIN_VALUE,Integer.MAX_VALUE,arr);
        System.out.println(is);
        Board.displayBoard();

//ArrayList<Integer>move =myMove.AllAvailableMoves(14,14,tempBoard);
//System.out.println(move);
//        ArrayList<Integer> availableMove;
//        int MyRow=3,MyColumn=11;
//        availableMove = myMove.AllAvailableMoves(MyRow,MyColumn);
//        for (int i=0;i<availableMove.size();i+=2){
//            System.out.println("row "+availableMove.get(i)+" colum "+availableMove.get(i+1));
//        }
//        myMove.printBoard();
//        myMove.updateBoard(MyRow,MyColumn,5,13);
//        myMove.printBoard();
    }
}