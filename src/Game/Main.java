package Game;
class Main {
    public static void main(String[] args) {
        Moves myMove = new Moves();
        int [][] availableMove = new int [6][2];
        int MyRow=6,MyColum=10;
        availableMove = myMove.AllAvailableMoves(MyRow,MyColum);
        for (int i=0;i<6;i++){
            System.out.println("row "+availableMove[i][0]+" colum "+availableMove[i][1]);
        }

        myMove.printBoard();
    }
}