package Game;
public class createBoard {
    private final int column =25;
    private final int row=17;
    private char gameBoard[][];
    public createBoard() {
        gameBoard=new char[row][column];
    }
    void initializeCornerOne(){
        int n=12;
        for (int i = 0; i <4; i++) {
            for (int j = 0; j <n; j++) {
                gameBoard[i][j]=' ';
            }
            n-=1;
        }
    }
    void initializeCornerTwo(){
        int x=13;
        for (int i = 0; i <4; i++) {
            for (int j = x; j <column; j++) {
                gameBoard[i][j]=' ';
            }
            x+=1;
        }
    }
    void initializeMidCorner(){
        int x=5;
        for(int i = 0; i < 4; ++i)
        {
            for(int j = 0; j <= i; ++j)
            {
                gameBoard[x][j]=' ';
            }
            x+=1;
        }
        x=5;
        for(int i = column-1; i >20; --i)
        {
            for(int j = column-1; j >= i; --j)
            {
                gameBoard[x][j]=' ';
            }
            x+=1;
        }
        int temp =x;
        for(int i = 3; i > 0; --i)
        {
            for(int j = 1; j <= i; ++j)
            {
                gameBoard[temp][j-1]=' ';
            }
            temp+=1;
        }
        for(int i = 22; i<=column-1 ; ++i)
        {
            for(int j = column-1; j >= i; --j)
            {
                gameBoard[x][j]=' ';
            }
            x+=1;
        }
    }


    char [][]getBoard(){
        return gameBoard;
    }
}
