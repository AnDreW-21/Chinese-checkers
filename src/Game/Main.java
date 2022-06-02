package Game;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Moves myMove = new Moves();
        ArrayList<Integer> availableMove = new ArrayList<Integer>() ;
        int MyRow=3,MyColum=11;
        availableMove = myMove.AllAvailableMoves(MyRow,MyColum);
        for (int i=0;i<availableMove.size();i+=2){
            System.out.println("row "+availableMove.get(i)+" colum "+availableMove.get(i+1));
        }

        myMove.printBoard();
        myMove.updateBoard(MyRow,MyColum,5,13);
        myMove.printBoard();
    }
}