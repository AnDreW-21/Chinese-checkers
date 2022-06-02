package Game;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {
    private int[] location;
    private HashMap<Point, Character> human;
    private HashMap<Point, Character> computer;

    Players() {
        human = new HashMap<Point, Character>();
        computer = new HashMap<Point, Character>();
        setHuman();
        setAiComputer();
    }

    private void setHuman() {
        human.put(new Point(0, 12), '1');
        human.put(new Point(1, 11), '1');
        human.put(new Point(1, 13), '1');
        human.put(new Point(2, 10), '1');
        human.put(new Point(2, 12), '1');
        human.put(new Point(2, 14), '1');
        human.put(new Point(3, 9), '1');
        human.put(new Point(3, 11), '1');
        human.put(new Point(3, 13), '1');
        human.put(new Point(3, 15), '1');

    }

    private void setAiComputer() {
        computer.put(new Point(16, 12), '6');
        computer.put(new Point(15, 11), '6');
        computer.put(new Point(15, 13), '6');
        computer.put(new Point(14, 10), '6');
        computer.put(new Point(14, 12), '6');
        computer.put(new Point(14, 14), '6');
        computer.put(new Point(13, 9), '6');
        computer.put(new Point(13, 11), '6');
        computer.put(new Point(13, 13), '6');
        computer.put(new Point(13, 15), '6');

    }

    public void displayHumanMoves() {
        System.out.println("Humans location Moves is:");
        System.out.println(human.keySet());
    }

    public void displayAiComputerMoves() {
        System.out.println("Humans location Moves is:");
        System.out.println(computer.keySet());
    }
    public void updaterPlayer(int round,int xP,int yP,int xC,int yC){
        if(round==0){
            human.put(new Point(xC, yC),'1');
            human.remove(new Point(xP, yP));
        }else {
            computer.put(new Point(xC, yC),'1');
            computer.remove(new Point(xP, yP));
        }
    }
    public void checkWinner(){
        boolean AiISWinner=false,humanIsWinner=false;
        for (Map.Entry me : human.entrySet()) {
            char x= (Character) me.getValue();
            if(x=='6'){
                AiISWinner=true;
            }else {
                AiISWinner=false;
                break;
            }
        }
        for (Map.Entry me : computer.entrySet()) {
            char x= (Character) me.getValue();
            if(x=='1'){
                humanIsWinner=true;
            }else {
                humanIsWinner=false;
                break;
            }
        }

    }


}
