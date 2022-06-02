package Game;

import java.util.ArrayList;
//-->c [][c]

public class Moves {
    private createBoard Board;
    char[][]board;
    public Moves (){
        Board = new createBoard();
        board = Board.getBoard();
        board[4][12]='1';
        board[6][12]='1';
        board[6][14]='1';
//        Board.displayWithoutDashAndNums();
    }
    private ArrayList<Integer> hop(int x,int y, int C_Row, int C_Colum){
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> availableArray = new ArrayList<Integer>();
        ///left_hop move
        if(board[x][y-2] !='O' &&board[x][y-4] =='O'){
            if(x != C_Row || y-4 != C_Colum){
                availableArray.add(x);
                availableArray.add(y-4);
                array = hop(x,y-4,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        ///right_hop move
        if(board[x][y+2] !='O' && board[x][y+4] =='O'){
            if(x != C_Row || y+4 != C_Colum){
                availableArray.add(x);
                availableArray.add(y+4);
                array = hop(x,y+4,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        ///down_right_hop move
        if(board[x+1][y+1] !='O' &&board[x+2][y+2] =='O'){
            if(x+2 != C_Row || y+2 != C_Colum){
                availableArray.add(x+2);
                availableArray.add(y+2);
                array = hop(x+2,y+2,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        ///down_left_hop move
        if(board[x+1][y-1] !='O' && board[x+2][y-2] =='O'){
            if(x+2 != C_Row || y-2 != C_Colum){
                availableArray.add(x+2);
                availableArray.add(y-2);
                array = hop(x+2,y-2,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        ///up_right_hop move
        if(board[x-1][y+1] !='O' && board[x-2][y+2] =='O'){
            if(x-2 != C_Row || y+2 != C_Colum){
                availableArray.add(x-2);
                availableArray.add(y+2);
                array = hop(x-2,y+2,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        ///up_left_hop move
        if(board[x-1][y-1] !='O' && board[x-2][y-2] =='O'){
            if(x-2 != C_Row || y-2 != C_Colum){
                availableArray.add(x-2);
                availableArray.add(y-2);
                array = hop(x-2,y-2,x,y);
                for(int i =0; i<array.size(); i++){
                    availableArray.add(array.get(i));
                }
            }
        }
        return availableArray;
    }
    public  ArrayList<Integer> AllAvailableMoves(int MyRow,int MyColum){
        ArrayList<Integer>availableMoves = new ArrayList<Integer>();
        ArrayList<Integer> array = new ArrayList<Integer>();
        ///left move
        if(board[MyRow][MyColum-2] =='O'){
            availableMoves.add(MyRow);
            availableMoves.add(MyColum-2);
        }else if(board[MyRow][MyColum-4] =='O'){
            availableMoves.add(MyRow);
            availableMoves.add(MyColum-4);
            array = hop(MyRow,MyColum-4,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        ///right move
        if(board[MyRow][MyColum+2] =='O'){
            availableMoves.add(MyRow);
            availableMoves.add(MyColum+2);
        }else if(board[MyRow][MyColum+4] =='O'){
            availableMoves.add(MyRow);
            availableMoves.add(MyColum+4);
            array = hop(MyRow,MyColum+4,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        ///down right move
        if(board[MyRow+1][MyColum+1] =='O'){
            availableMoves.add(MyRow+1);
            availableMoves.add(MyColum+1);
        }else if(board[MyRow+2][MyColum+2] =='O'){
            availableMoves.add(MyRow+2);
            availableMoves.add(MyColum+2);
            array = hop(MyRow+2,MyColum+2,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        ///down left move
        if(board[MyRow+1][MyColum-1] =='O'){
            availableMoves.add(MyRow+1);
            availableMoves.add(MyColum-1);
        }else if(board[MyRow+2][MyColum-2] =='O'){
            availableMoves.add(MyRow+2);
            availableMoves.add(MyColum-2);
            array = hop(MyRow+2,MyColum-2,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        ///up right move
        if(board[MyRow-1][MyColum+1] =='O'){
            availableMoves.add(MyRow-1);
            availableMoves.add(MyColum+1);
        }else if(board[MyRow-2][MyColum+2] =='O'){
            availableMoves.add(MyRow-2);
            availableMoves.add(MyColum+2);
            array = hop(MyRow-2,MyColum+2,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        ///up left move
        if(board[MyRow-1][MyColum-1] =='O'){
            availableMoves.add(MyRow-1);
            availableMoves.add(MyColum-1);
        }else if(board[MyRow-2][MyColum-2] =='O'){
            availableMoves.add(MyRow-2);
            availableMoves.add(MyColum-2);
            array = hop(MyRow-2,MyColum-2,MyRow,MyColum);
            for(int i =0; i<array.size(); i++){
                availableMoves.add(array.get(i));
            }
        }
        return availableMoves;
    }
    public void printBoard(){
        Board.displayWithoutDashAndNums();
    }
    public void updateBoard(int MyRow,int MyColum,int MyNewRow,int MyNewColum){
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] ='O';
    }
}
