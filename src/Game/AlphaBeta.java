//package Game;
//
//import java.util.ArrayList;
//
//public class AlphaBeta {
//
//    private static int MAX = Integer.MAX_VALUE;
//    private static int MIN = Integer.MIN_VALUE;
//
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
//
//    public int heuristic(Point point , int MyRow){
//        int distance = MyRow - point.getX();
//        return distance;
//    }
//
//
//
//}
