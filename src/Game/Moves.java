package Game;

import java.util.ArrayList;
//-->c [][c]

public class Moves {
    char[][] board;

    public void setBoard(char[][] board) {
        this.board = board;
    }


    private ArrayList<Integer> hop(int x, int y, int C_Row, int C_Colum,char[][] board) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        ArrayList<Integer> availableArray2 = new ArrayList<Integer>();
        ///left_hop move
        if((x)< 17 && (y-2)>=0  && (y-4)>=0) {
            if (board[x][y - 2] != 'O' && board[x][y - 4] == 'O') {
                if (x != C_Row || y - 4 != C_Colum) {
                    availableArray2.add(x);
                    availableArray2.add(y - 4);
                    array = hop(x, y - 4, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        ///right_hop move
        if((x)< 17 && (y+2)<25  && (y+4)<25) {
            if (board[x][y + 2] != 'O' && board[x][y + 4] == 'O') {
                if (x != C_Row || y + 4 != C_Colum) {
                    availableArray2.add(x);
                    availableArray2.add(y + 4);
                    array = hop(x, y + 4, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        ///down_right_hop move
        if((x+1)< 17 && (y+1)<25 && (x+2)< 17 && (y+2)<25) {
            if (board[x + 1][y + 1] != 'O' && board[x + 2][y + 2] == 'O') {
                if (x + 2 != C_Row || y + 2 != C_Colum) {
                    availableArray2.add(x + 2);
                    availableArray2.add(y + 2);
                    array = hop(x + 2, y + 2, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        ///down_left_hop move
        if((x+1)< 17 && (y-1)>=0 && (x+2)< 17 && (y-2)>=0) {
            if (board[x + 1][y - 1] != 'O' && board[x + 2][y - 2] == 'O') {
                if (x + 2 != C_Row || y - 2 != C_Colum) {
                    availableArray2.add(x + 2);
                    availableArray2.add(y - 2);
                    array = hop(x + 2, y - 2, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        ///up_right_hop move
        if((x-1)>=0 && (y+1)<25 && (x-2)>=0 && (y+2)<25) {
            if (board[x - 1][y + 1] != 'O' && board[x - 2][y + 2] == 'O') {
                if (x - 2 != C_Row || y + 2 != C_Colum) {
                    availableArray2.add(x - 2);
                    availableArray2.add(y + 2);
                    array = hop(x - 2, y + 2, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        ///up_left_hop move
        if((x-1)>=0 && (y-1)>=0 && (x-2)>=0 && (y-2)>=0) {
            if (board[x - 1][y - 1] != 'O' && board[x - 2][y - 2] == 'O') {
                if (x - 2 != C_Row || y - 2 != C_Colum) {
                    availableArray2.add(x - 2);
                    availableArray2.add(y - 2);
                    array = hop(x - 2, y - 2, x, y, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableArray2.add(array.get(i));
                    }
                }
            }
        }
        return availableArray2;
    }

    public ArrayList<Integer> AllAvailableMoves(int MyRow, int MyColum,char[][] board) {
        ArrayList<Integer> availableMoves = new ArrayList<Integer>();
        ArrayList<Integer> array ;
        ///left move
        if(MyRow< 17 && (MyColum-2)>=0) {
            if (board[MyRow][MyColum - 2] == 'O') {
                availableMoves.add(MyRow);
                availableMoves.add(MyColum - 2);
            }else if (MyRow< 17 && (MyColum-4)>=0) {
                if (board[MyRow][MyColum - 4] == 'O') {
                availableMoves.add(MyRow);
                availableMoves.add(MyColum - 4);
                array = hop(MyRow, MyColum - 4, MyRow, MyColum, board);
                for (int i = 0; i < array.size(); i++) {
                    availableMoves.add(array.get(i));
                }
            }
        }
        }
        ///right move
        if(MyRow< 17 && (MyColum+2)<25) {
            if (board[MyRow][MyColum + 2] == 'O') {
                availableMoves.add(MyRow);
                availableMoves.add(MyColum + 2);
            } else if(MyRow< 17 && (MyColum+4)<25) {
                if (board[MyRow][MyColum + 4] == 'O') {
                    availableMoves.add(MyRow);
                    availableMoves.add(MyColum + 4);
                    array = hop(MyRow, MyColum + 4, MyRow, MyColum, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableMoves.add(array.get(i));
                    }
                }
            }
        }
        ///down right move
        if((MyRow+1)< 17 && (MyColum+1)<25) {
            if (board[MyRow + 1][MyColum + 1] == 'O') {
                availableMoves.add(MyRow + 1);
                availableMoves.add(MyColum + 1);
            } else if ((MyRow + 2) < 17 && (MyColum + 2) < 25) {
                if (board[MyRow + 2][MyColum + 2] == 'O') {
                    availableMoves.add(MyRow + 2);
                    availableMoves.add(MyColum + 2);
                    array = hop(MyRow + 2, MyColum + 2, MyRow, MyColum, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableMoves.add(array.get(i));
                    }
                }
            }
        }
        ///down left move
        if((MyRow+1)< 17 && (MyColum-1)>=0) {
            if (board[MyRow + 1][MyColum - 1] == 'O') {
                availableMoves.add(MyRow + 1);
                availableMoves.add(MyColum - 1);
            } else if((MyRow+2)< 17 && (MyColum-2)>=0){
                if (board[MyRow + 2][MyColum - 2] == 'O') {
                    availableMoves.add(MyRow + 2);
                    availableMoves.add(MyColum - 2);
                    array = hop(MyRow + 2, MyColum - 2, MyRow, MyColum, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableMoves.add(array.get(i));
                    }
                }
            }
        }
        ///up right move
        if((MyRow-1)>=0 && (MyColum+1)<25) {
            if (board[MyRow - 1][MyColum + 1] == 'O') {
                availableMoves.add(MyRow - 1);
                availableMoves.add(MyColum + 1);
            } else if((MyRow-2)>=0 && (MyColum+2)<25){
                if (board[MyRow - 2][MyColum + 2] == 'O') {
                    availableMoves.add(MyRow - 2);
                    availableMoves.add(MyColum + 2);
                    array = hop(MyRow - 2, MyColum + 2, MyRow, MyColum, board);
                    for (int i = 0; i < array.size(); i++) {
                        availableMoves.add(array.get(i));
                    }
                }
            }
        }
        ///up left move
        if((MyRow-1)>=0 && (MyColum-1)>=0){
        if (board[MyRow - 1][MyColum - 1] == 'O') {
            availableMoves.add(MyRow - 1);
            availableMoves.add(MyColum - 1);
        } else if((MyRow-2)>=0 && (MyColum-2)>=0) {
            if (board[MyRow - 2][MyColum - 2] == 'O') {
                availableMoves.add(MyRow - 2);
                availableMoves.add(MyColum - 2);
                array = hop(MyRow - 2, MyColum - 2, MyRow, MyColum,board);
                for (int i = 0; i < array.size(); i++) {
                    availableMoves.add(array.get(i));
                }
            }
          }
        }
        return availableMoves;
    }


    public int checkWinner(char [][]board) {
        boolean computer = false,human=false;
        int start = 9, end = 16, r = 3;
        char temp = '-';
        for (int i = r; i >= 0; --i) {
            for (int j = start; j < end; ++j) {
                if (temp != '-') {
                    if (board[i][j] == '6') {
                        computer = true;
                    }
                } else {
                    computer = false;
                    return -1;
                }
            }
            start++;
            end--;
        }
        start = 9;
        end = 16; r = 13;
        for (int i = r; i <= 16; ++i) {
            for (int j = start; j < end; ++j) {
                if (j == start || temp != '-') {
                    board[i][j] = '1';
                    human=true;
                } else {
                    human=false;
                    return -1;
                }
            }
            start++;
            end--;
        }
        if(human){
            return 1;
        }else if (computer){
            return 2;
        }
        return 0;
    }
}

