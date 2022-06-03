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
        players.displayHumanMoves();
        char [][]tempBoard=Board.getBoard();

        ArrayList<Integer> is= AlphaBeta.minimax(tempBoard,3,players.getComputer(),players.getHuman(), true);


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