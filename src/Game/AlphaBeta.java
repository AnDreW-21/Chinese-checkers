package Game;
import java.lang.Math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

public class AlphaBeta {

    private static int MAX = Integer.MAX_VALUE;
    private static int MIN = Integer.MIN_VALUE;

    public static  char [][] updateBoard(char[][] board, int MyRow, int MyColum, int MyNewRow, int MyNewColum) {
        board[MyNewRow][MyNewColum] = board[MyRow][MyColum];
        board[MyRow][MyColum] = 'O';
        return board;
    }

    public static HashMap<Point, Character> updatePlayer(HashMap<Point, Character> map, int xP, int yP, int xC, int yC, char round) {
        map.put(new Point(xC, yC),round);
        for (Map.Entry mapElement : map.entrySet()) {
            Point p =(Point) mapElement.getKey();
            if(p.getX() ==xP && p.getY() == yP){
                map.remove(p);
                break;
            }
        }
        return map;
    }

    public static int heuristic2(int point, int MyRow) {
        return  Math.abs(MyRow-point);
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

    public static ArrayList<Integer> alphaBeta(char[][] board, int depth, HashMap<Point, Character> computer, HashMap<Point, Character> human,Boolean maximizingPlayer,
                                        int alpha, int beta , ArrayList<Integer> comeingPoint )
    {
        if (depth == 0) {
            return comeingPoint;
            //heuristic
        }
        if (maximizingPlayer)
        {
            int best ;
            int val =MIN;
            int best1 = MIN;
            ArrayList<Integer> bestPoint = new ArrayList<Integer>();
            HashMap<Point, Character> newComputer1 = (HashMap<Point, Character>) computer.clone();
            for (Map.Entry<Point, Character> entry : computer.entrySet()) {
                Point p = entry.getKey();
                ArrayList<Integer> str = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                for (int j = 0; j < str.size(); j += 2) {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    char[][] tempBoard = new char[17][];
                    for (int i = 0; i < 17; i++) {
                        tempBoard[i] = board[i].clone();
                    }
                    char [][] Newboard=updateBoard(tempBoard, p.getX(), p.getY(), str.get(j), str.get(j+1));
                    array.add(p.getX());
                    array.add(p.getY());
                    array.add(str.get(j));
                    array.add(str.get(j+1));
                    HashMap<Point, Character> newComputer = updatePlayer(newComputer1, p.getX(), p.getY(), str.get(j), str.get(j+1), '6');
                    ArrayList<Integer> arr2 = alphaBeta(Newboard, depth-1, newComputer, human, false,alpha, beta ,array);
                    if(!arr2.isEmpty()) {
                         val = heuristic2(arr2.get(2), arr2.get(0));
                    }
                    if(!bestPoint.isEmpty()) {
                        best1 = heuristic2(bestPoint.get(2), bestPoint.get(0));
                    }

                    best = Math.max(best1, val);
                    alpha = Math.max(alpha, best);
                    if(best == val){
                        bestPoint = arr2;
                    }
                    if (beta <= alpha)
                        break;
                }
            }

            return bestPoint;
        }
        else
        {
            int best ;
            int best1 = MAX;
            int val = MAX;
            ArrayList<Integer> bestPoint = new ArrayList<Integer>();
            HashMap<Point, Character> newHuman1 = (HashMap<Point, Character>) human.clone();
            for (Map.Entry<Point, Character> entry : human.entrySet()) {
                Point p = entry.getKey();
                ArrayList<Integer> str2 = Main.myMove.AllAvailableMoves(p.getX(), p.getY(), board);
                for (int j = 0; j < str2.size(); j += 2) {
                    ArrayList<Integer> array = new ArrayList<Integer>();
                    char[][] tempBoard = new char[17][];
                    for (int i = 0; i < 17; i++) {
                        tempBoard[i] = board[i].clone();
                    }
                    char [][] Newboard=updateBoard(board, p.getX(), p.getY(), str2.get(j), str2.get(j+1));
                    array.add(p.getX());
                    array.add(p.getY());
                    array.add(str2.get(j));
                    array.add(str2.get(j+1));
                    HashMap<Point, Character> newhuman = updatePlayer(newHuman1, p.getX(), p.getY(), str2.get(j), str2.get(j+1), '1');
                    ArrayList<Integer> arr2 = alphaBeta(Newboard, depth-1, computer, newhuman, true,alpha, beta, array);
                    arr2.add(array.get(0));
                    arr2.add(array.get(1));
                    arr2.add(array.get(2));
                    arr2.add(array.get(3));

                    if(!arr2.isEmpty()) {
                        val = heuristic2(arr2.get(2), arr2.get(0));
                    }
                    if(!bestPoint.isEmpty()) {
                        best1 = heuristic2(bestPoint.get(2), bestPoint.get(0));
                    }
                    best = Math.min(best1, val);
                    beta = Math.min(beta, best);
                    if(best == val){
                        bestPoint = arr2;
                    }
                    if (beta <= alpha)
                        break;
                }
            }
            return bestPoint;
        }
    }
}
