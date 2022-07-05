package baek.num3190;

import java.util.*;

public class Main {
    static int[][] body = new int[101][101];
    static int[][] apple = new int[101][101];
    static Map<Integer, Character> moveM = new HashMap<>();
    static Deque<Pair> bodyDeq = new ArrayDeque<Pair>();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        int appleNUm;
        int m;
        int count = 0;
        int angle = 90;
        int headR, headC, tailR, tailC;

        n = sc.nextInt();
        body[1][1] = 1;
        bodyDeq.add(new Pair(1,1));

        appleNUm = sc.nextInt();
        for(int i=0; i<appleNUm; i++){
            int row = sc.nextInt();
            int column = sc.nextInt();
            apple[row][column] = 1;
        }

        m = sc.nextInt();
        for(int i=0; i<m; i++){
            int second = sc.nextInt();
            String direction = sc.next();
            moveM.put(second, direction.charAt(0));
        }

        headR = 1;
        headC = 1;
        while(true){
            count++;
            if(angle == 0)
                headR--;
            else if(angle == 90)
                headC++;
            else if(angle == 180)
                headR++;
            else if(angle == 270)
                headC--;
            if(!moveHead(headR, headC, angle, n+1)){
                break;
            }

            body[headR][headC] = 1;
            bodyDeq.addFirst(new Pair(headR, headC));

            if(apple[headR][headC] == 0){
                Pair tempPair = bodyDeq.removeLast();
                body[tempPair.row][tempPair.column] = 0;
            }
            else{
                apple[headR][headC] = 0;
            }
            angle = rotate(count, angle);
        }
        System.out.println(count);
    }

    public static boolean moveHead(int headR, int headC, int angle, int size){
        if((angle == 0 && headR == 0) || (angle == 90 && headC == size) || (angle == 180 && headR == size) || (angle == 270 && headC == 0)) {
            return false;
        }

        if(body[headR][headC] == 1){
            return false;
        }

        return true;
    }

    public static int rotate(int count, int angle){
        if(moveM.get(count) != null && 'L' == moveM.get(count)) {
            if(angle == 0)
                return 270;
            else
                return angle - 90;
        }
        else if(moveM.get(count) != null && 'D' == moveM.get(count)) {
            if (angle == 270)
                return 0;
            else
                return angle + 90;
        }
        else
            return angle;
    }

    static class Pair {
        int row;
        int column;

        public Pair(int row, int column){
            this.row = row;
            this.column = column;
        }
    }
}
