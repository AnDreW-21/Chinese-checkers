package Game;

public class createBoard {
    private final int column = 25;
    private final int row = 17;
    private char gameBoard[][];

    public createBoard() {
        gameBoard = new char[row][column];
        drawBoard();
    }

    private void initializeCornerOne() {
        int n = 12;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < n; j++) {
                gameBoard[i][j] = ' ';
            }
            n -= 1;
        }
    }

    private void initializeCornerTwo() {
        int x = 13;
        for (int i = 0; i < 4; i++) {
            for (int j = x; j < column; j++) {
                gameBoard[i][j] = ' ';
            }
            x += 1;
        }
    }

    private void initializeMidCorner() {
        int x = 5;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j <= i; ++j) {
                gameBoard[x][j] = ' ';
            }
            x += 1;
        }
        x = 5;
        for (int i = column - 1; i > 20; --i) {
            for (int j = column - 1; j >= i; --j) {
                gameBoard[x][j] = ' ';
            }
            x += 1;
        }
        int temp = x;
        for (int i = 3; i > 0; --i) {
            for (int j = 1; j <= i; ++j) {
                gameBoard[temp][j - 1] = ' ';
            }
            temp += 1;
        }
        for (int i = 22; i <= column - 1; ++i) {
            for (int j = column - 1; j >= i; --j) {
                gameBoard[x][j] = ' ';
            }
            x += 1;
        }
    }

    private void lastLeftCorner() {
        int x = 13, count = 9;
        for (int i = x; i < row; i++) {
            for (int j = 0; j < count; j++) {
                gameBoard[i][j] = ' ';
            }
            count += 1;
        }
    }

    private void lastRightCorner() {
        int x = 13, count = 16;
        for (int i = x; i < row; i++) {
            for (int j = count; j < column; j++) {
                gameBoard[i][j] = ' ';
            }
            count -= 1;
        }
    }

    private void createTheFistHalfOfBoard() {
        int c = 0;
        int r = 4;
        int end = column - 1;
        char temp = 'O';
        int start = 0;
        while (r < 13) {
            for (int i = start; i <= end; i++) {
                if (i == start || temp == '-') {
                    gameBoard[r][i] = 'O';
                    temp = 'O';
                } else {
                    gameBoard[r][i] = '-';
                    temp = '-';
                }
            }
            r++;
            end--;
            start++;
        }
    }

    private void drawBoard() {
        initializeCornerOne();
        initializeCornerTwo();
        initializeMidCorner();
        lastLeftCorner();
        lastRightCorner();
        createTheFistHalfOfBoard();
        setPlayer1();
        setPlayer2();
        setPlayer3();
        setPlayer4();
        setPlayer5();
        setPlayer6();
    }

    public char[][] getBoard() {
        return gameBoard;
    }

    void displayBoard() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void setPlayer1() {
        int start = 9, end = 16, r = 3;
        char temp = '-';
        for (int i = r; i >= 0; --i) {
            for (int j = start; j < end; ++j) {
                if (j == start || temp == '-') {
                    gameBoard[i][j] = '1';
                    temp = '1';
                } else {
                    gameBoard[i][j] = '-';
                    temp = '-';
                }
            }
            start++;
            end--;
        }
    }

    private void setPlayer2() {
        int start = 0, end = 6, r = 4;
        char temp = '-';
        for (int i = r; i <= 7; ++i) {
            for (int j = start; j <= end; ++j) {
                if (j == start || temp == '-') {
                    gameBoard[i][j] = '2';
                    temp = '2';
                } else {
                    gameBoard[i][j] = '-';
                    temp = '-';
                }
            }
            start++;
            end--;
        }
    }

    private void setPlayer3() {
        int start = 18, end = 24, r = 4;
        char temp = '8';
        for (int i = r; i <= 7; ++i) {
            for (int j = start; j <= end; ++j) {
                if (j == start || temp == '8') {
                    gameBoard[i][j] = '3';
                    temp = '3';
                } else {
                    gameBoard[i][j] = '-';
                    temp = '8';
                }
            }
            start++;
            end--;
        }
    }

    private void setPlayer4() {
        int start = 0, end = 7, r = 12;
        char temp = '8';
        for (int i = r; i >= 9; --i) {
            for (int j = start; j <= end; ++j) {
                if (j == start || temp == '8') {
                    gameBoard[i][j] = '4';
                    temp = '3';
                } else {
                    gameBoard[i][j] = '-';
                    temp = '8';
                }
            }
            start++;
            end--;
        }
    }

    private void setPlayer5() {
        int start = 17, end = 24, r = 12;
        char temp = '8';
        for (int i = r; i >= 9; --i) {
            for (int j = start; j <= end; ++j) {
                if (j == start || temp == '8') {
                    gameBoard[i][j] = '-';
                    temp = '3';
                } else {
                    gameBoard[i][j] = '5';
                    temp = '8';
                }
            }
            start++;
            end--;
        }
    }

    private void setPlayer6() {
        int start = 9, end = 16, r = 13;
        char temp = '8';
        for (int i = r; i <= 16; ++i) {
            for (int j = start; j < end; ++j) {
                if (j == start || temp == '8') {
                    gameBoard[i][j] = '6';
                    temp = '6';
                } else {
                    gameBoard[i][j] = '-';
                    temp = '8';
                }
            }
            start++;
            end--;
        }
    }

    void displayWithoutDash() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gameBoard[i][j] != '-') {
                    System.out.print(gameBoard[i][j] + " ");
                } else
                    System.out.print("  ");
            }
            System.out.println("");
        }

    }

    void displayWithoutDashAndNums() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (gameBoard[i][j] == '-') {
                    System.out.print("  ");

                } else if (gameBoard[i][j] != 'O' && gameBoard[i][j] != ' ') {
                    System.out.print("*" + " ");
                } else
                    System.out.print(gameBoard[i][j] + " ");


            }
            System.out.println("");
        }

    }
}
