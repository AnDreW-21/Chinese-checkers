package Game;

class Main {
    public static void main(String[] args) {
        createBoard board=new createBoard();
        board.displayBoard();
        Players players=new Players();
        players.displayHumanMoves();
//        Moves myMove = new Moves();
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