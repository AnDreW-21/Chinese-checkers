package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlphaBeta {

    private static int MAX = Integer.MAX_VALUE;
    private static int MIN = Integer.MIN_VALUE;
    public static void updateBoard(char[][] board, int MyRow, int MyColum, int MyNewRow, int MyNewColum) {
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] = 'O';
    }

    public static Point minimax(char[][] board, int depth, Map<Point, Character> computer, boolean isMax, int best) {
        if (depth == 0)
            return new Point(0, 0);
        for (Map.Entry<Point, Character> entry : computer.entrySet()) {
            Point p=entry.getKey();
            ArrayList<Integer> str = Main.myMove.AllAvailableMoves(p.getX(),p.getY(),board);
            for (int j = 0; j < str.size(); j+=2) {
                updateBoard(board,p.getX(), p.getY(), str.get(j), str.get(j++));
                minimax(board, depth - 1,computer, isMax,best);
                board=Main.myMove.board;
            }
        }
        return new Point(1, 2);
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

    public int heuristic(Point point, int MyRow) {
        int distance = MyRow - point.getX();
        return distance;
    }


}
