package hanoi;

import java.util.Stack;

public class gameHanoi {
    final static int NUMBEROFDISKS = 4;
    final static int TOTALLENGTH = NUMBEROFDISKS * 2;
    static Stack<Disk>[] towers = new Stack[3];


    public static void main(String[] args) {
        setBoard(towers);
        printBoard(towers);
        System.out.println(" ");
        play(NUMBEROFDISKS, 0, 2, towers);
    }

    private static void play(int nDisks, int from, int to, Stack<Disk>[] towers) {

        if(nDisks == 1){
            towers[to].push(towers[from].pop());
            printBoard(towers);
            System.out.println(" ");
        } else {
            int help = 3 - from - to;
            play(nDisks - 1, from, help, towers);

            towers[to].push(towers[from].pop());
            printBoard(towers);
            System.out.println(" ");

            play(nDisks - 1, help, to, towers);
        }
    }

    private static void printBoard(Stack<Disk>[] towers) {
        String print = "";
        for(int i = NUMBEROFDISKS - 1; i >= 0; i--) {
            print = "";
            for (int x = 0; x < towers.length; x++) {
                if (towers[x].size() <= i) {
                    print += ".".repeat(TOTALLENGTH) + " ";
                } else {
                    print += towers[x].get(i).getVisualLength(TOTALLENGTH) + " ";
                }
            }
            System.out.println(print);
        }
    }


    private static void setBoard(Stack<Disk>[] towers) {
        for (int i = 0; i < 3; i++){
            towers[i] = new Stack<>();
        }

         for (int i = 0; i < NUMBEROFDISKS; i++){
                 int length = TOTALLENGTH - i - i;
                 Disk disk = new Disk(length);
                 towers[0].push(disk);
        }
    }
}
