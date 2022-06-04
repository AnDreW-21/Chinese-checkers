package Game;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Map;

public class AlphaBeta {

    private static int MAX = Integer.MAX_VALUE;
    private static int MIN = Integer.MIN_VALUE;
    public static  char [][] updateBoard(char[][] board, int MyRow, int MyColum, int MyNewRow, int MyNewColum) {
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] = 'O';
        return board;
    }

    public static void updatePlayer(Point[] map, int xP, int yP, int xC, int yC, char round) {
        for (int i=0;i<10;i++) {
            if(map[i].getX()==xP && map[i].getY()==yP){
                map[i].setX(xC);
                map[i].setY(yC);
                break;
            }
        }
    }

    public static int heuristic(Point point, int MyRow) {
        return  Math.abs(point.getX()-MyRow);
    }
    public static int [] max(int [] arrayList, int [] arrayList2) {
        if (arrayList[0] > arrayList2[0])
            return arrayList;
        return arrayList2;
    }

    public static int [] min(int [] arrayList, int [] arrayList2) {
        if (arrayList[0] < arrayList2[0])
            return arrayList;
        return arrayList2;
    }

    public static int [] minimax(char[][] board, int depth, Point []computer, Point [] human, boolean isMax) {
        int [] arr = new int[5];
        if (depth == 0){
            arr[0]=-1000;
            return arr;
        }
        if (isMax) {
            for (int i=0;i<10;i++) {
                Point p = computer[i];
                ArrayList<Integer> str = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                int z=0;
                for (int j = 0; j < (str.size()/2); j ++) {
                    int x = heuristic(new Point(str.get(j), str.get(j + 1)), p.getX());
                    arr[0]=x;
                    arr[1]=p.getX();
                    arr[2]=p.getY();
                    arr[3]=str.get(z);
                    arr[4]=str.get(z+1);
                    updateBoard(board, p.getX(), p.getY(), str.get(j), str.get(j++));
                    updatePlayer(computer, p.getX(), p.getY(), str.get(j), str.get(j++), '6');
                    int [] arr2 = minimax(board, depth - 1, computer, human, false);
                    arr = max(arr, arr2);
                    board = Main.Board.getBoard();
                    computer = Main.players.switchComputer(computer);
                }
            }
            return arr;
        } else {
            for (int i=0;i<10;i++) {
                Point p = human[i];
                ArrayList<Integer> strs = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                for (int j = 0; j < (strs.size()/2); j += 2) {
                    int x = heuristic(new Point(strs.get(j), strs.get(j + 1)), p.getX());
                    arr[0]=x;
                    arr[1]=p.getX();
                    arr[2]=p.getY();
                    arr[3]=strs.get(j);
                    arr[4]=strs.get(j+1);
                    updateBoard(board, p.getX(), p.getY(), strs.get(j), strs.get(j+1));
                    updatePlayer(human, p.getX(), p.getY(), strs.get(j), strs.get(j+1), '1');
                    int []arr3 = minimax(board, depth - 1, computer, human, true);
                    arr = min(arr, arr3);
                    board = Main.Board.getBoard();
                    human = Main.players.switchComputer(human);
                }
            }
        }
        return arr;

    }
    //    int score=evaluate(board, p, 6);

//    public int minimax(int depth,int nodeIndex, Boolean maximizingPlayer,Point[] values, int alpha, int beta)
//    {
//        ArrayList<Integer> array = new ArrayList<Integer>();
//        Point[] valuesOfMoves;
//
//        if (depth == 0) {
//            return values[nodeIndex];
//            //heuristic
//        }
//        if (maximizingPlayer)
//        {
//            int best = MIN;
//
//            for (int i = 0; i < 2; i++)
//            {
//                int val = minimax(depth - 1, nodeIndex * 2 + i,false, values, alpha, beta);
//                array = Main.myMove.AllAvailableMoves(values[i].getX(),values[i].getY());
//                valuesOfMoves = new Point[array.size()/2];
//                int x =0;
//                for (int j = 0; j < array.size(); j+=2) {
//                    Point p = new Point(array.get(j),array.get(j+1));
//                    p.setDistance(heuristic(p,values[i].getX()));
//                    valuesOfMoves[x] = p;
//                }
//                best = Math.max(best, val);
//                alpha = Math.max(alpha, best);
//
//                // Alpha Beta Pruning
//                if (beta <= alpha)
//                    break;
//            }
//            return best;
//        }
//        else
//        {
//            int best = MAX;
//
//            for (int i = 0; i < 2; i++)
//            {
//
//                int val = minimax(depth + 1, nodeIndex * 2 + i, true, values, alpha, beta);
//                best = Math.min(best, val);
//                beta = Math.min(beta, best);
//
//                // Alpha Beta Pruning
//                if (beta <= alpha)
//                    break;
//            }
//            return best;
//        }
//    }
}
