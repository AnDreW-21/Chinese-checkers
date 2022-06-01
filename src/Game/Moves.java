package Game;

import java.util.ArrayList;
//-->c [][c]

public class Moves {
    private createBoard Board;
    char[][]board;
    public Moves (){
        Board = new createBoard();
        board = Board.getBoard();
        //board[4][12]='1';
//        Board.displayWithoutDashAndNums();
    }
    public int[][] AllAvailableMoves(int MyRow,int MyColum){
        int [][] availableMove = new int [6][2];
        int i=0;
        ///left move
        if(board[MyRow][MyColum-2] =='O'){
            availableMove[i][0] =MyRow;
            availableMove[i][1] = MyColum-2;
            i++;
        }else if(board[MyRow][MyColum-4] =='O'){
            availableMove[i][0] =MyRow;
            availableMove[i][1] = MyColum-4;
            i++;
        }
        ///right move
        if(board[MyRow][MyColum+2] =='O'){
            availableMove[i][0] =MyRow;
            availableMove[i][1] = MyColum+2;
            i++;
        }else if(board[MyRow][MyColum+4] =='O'){
            availableMove[i][0] =MyRow;
            availableMove[i][1] = MyColum+4;
            i++;
        }
        ///down right move
        if(board[MyRow+1][MyColum+1] =='O'){
            availableMove[i][0] =MyRow+1;
            availableMove[i][1] = MyColum+1;
            i++;
        }else if(board[MyRow+2][MyColum+2] =='O'){
            availableMove[i][0] =MyRow+2;
            availableMove[i][1] = MyColum+2;
            i++;
        }
        ///down left move
        if(board[MyRow+1][MyColum-1] =='O'){
            availableMove[i][0] =MyRow+1;
            availableMove[i][1] = MyColum-1;
            i++;
        }else if(board[MyRow+2][MyColum-2] =='O'){
            availableMove[i][0] =MyRow+2;
            availableMove[i][1] = MyColum-2;
            i++;
        }
        ///up right move
        if(board[MyRow-1][MyColum+1] =='O'){
            availableMove[i][0] =MyRow-1;
            availableMove[i][1] = MyColum+1;
            i++;
        }else if(board[MyRow-2][MyColum+2] =='O'){
            availableMove[i][0] =MyRow-2;
            availableMove[i][1] = MyColum+2;
            i++;
        }
        ///up left move
        if(board[MyRow-1][MyColum-1] =='O'){
            availableMove[i][0] =MyRow-1;
            availableMove[i][1] = MyColum-1;
            i++;
        }else if(board[MyRow-2][MyColum-2] =='O'){
            availableMove[i][0] =MyRow-2;
            availableMove[i][1] = MyColum-2;
            i++;
        }
        return availableMove;
    }
    public void printBoard(){
        Board.displayWithoutDashAndNums();
    }
    public void updateBoard(int MyRow,int MyColum,int MyNewRow,int MyNewColum){
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] ='O';
    }
    public boolean Jumpcheck(int MyRow,int MyColum,int MyNewRow,int MyNewColum){
        updateBoard(MyRow,MyColum,MyNewRow,MyNewColum);
        if(MyNewRow == MyRow-2 && MyNewColum == MyColum-2){// up_left jump
         return true;
        }else if(MyNewRow == MyRow-2 && MyNewColum == MyColum+2){//up_right jump
            return true;
        }else if(MyNewRow == MyRow+2 && MyNewColum == MyColum-2){//down_left jump
            return true;
        }else if(MyNewRow == MyRow+2 && MyNewColum == MyColum+2){//down_right jump
            return true;
        }else if(MyNewRow == MyRow && MyNewColum==MyColum+4){//right jump
            return true;
        }else if(MyNewRow == MyRow && MyNewColum==MyColum-4){//left jump
            return true;
        }
        return false;
    }
}
