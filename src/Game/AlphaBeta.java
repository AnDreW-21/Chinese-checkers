package Game;

import javax.swing.*;
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

    public static void updatePlayer(Map<Point, Character> map, int xP, int yP, int xC, int yC, char round) {
        map.put(new Point(xC, yC), round);
        map.remove(new Point(xP, yP));
    }

    public static int heuristic(Point point, int MyRow) {
        return MyRow - point.getX();
    }

    public static ArrayList<Integer> max(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.get(0) > arrayList2.get(0))
            return arrayList;
        return arrayList2;
    }

    public static ArrayList<Integer> min(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        if (arrayList.get(0) < arrayList2.get(0))
            return arrayList;
        return arrayList2;
    }

    public static ArrayList<Integer> minimax(char[][] board, int depth, Map<Point, Character> computer, Map<Point, Character> human, boolean isMax) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if (depth == 0)
            return arr;
        if (isMax) {
            for (Map.Entry<Point, Character> entry : computer.entrySet()) {
                Point p = entry.getKey();
                ArrayList<Integer> str = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                for (int j = 0; j < str.size(); j += 2) {
                    updateBoard(board, p.getX(), p.getY(), str.get(j), str.get(j++));
                    int x = heuristic(new Point(str.get(j), str.get(j + 1)), p.getX());
                    arr.add(x);
                    arr.add(p.getX(), p.getY());
                    arr.add(str.get(j));
                    arr.add(str.get(j++));
                    updatePlayer(computer, p.getX(), p.getY(), str.get(j), str.get(j++), '6');
                    ArrayList<Integer> arr2 = minimax(board, depth - 1, computer, human, false);
                    arr = max(arr, arr2);
                    board = Main.myMove.board;
                    computer = Main.players.getComputer();
                }
            }
            return arr;
        } else {
            for (Map.Entry<Point, Character> entry : human.entrySet()) {
                Point p = entry.getKey();
                ArrayList<Integer> strs = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                for (int j = 0; j < strs.size(); j += 2) {
                    int x = heuristic(new Point(strs.get(j), strs.get(j + 1)), p.getX());
                    arr.add(x);
                    arr.add(p.getX(), p.getY());
                    arr.add(strs.get(j));
                    arr.add(strs.get(j++));
                    updateBoard(board, p.getX(), p.getY(), strs.get(j), strs.get(j++));
                    updatePlayer(computer, p.getX(), p.getY(), strs.get(j), strs.get(j++), '1');
                    ArrayList<Integer> arr3 = minimax(board, depth - 1, computer, human, true);
                    arr = max(arr, arr3);
                    board = Main.myMove.board;
                    human = Main.players.getHuman();
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
