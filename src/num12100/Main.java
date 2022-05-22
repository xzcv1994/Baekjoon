package num12100;

import java.util.Scanner;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] board = new int[size][size];

        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                board[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<4; i++){
            int[][] temp = board;
            move(board, 1, i);
        }

    }

    public static void move(int[][] board, int cnt, int direction){
        if(cnt == 6)
            cal(board);

       switch (direction){
           case 0:
               break;
           case 1:
               break;
           case 2:
               break;
           case 3:
               break;
       }


    }

    public static int cal(int[][] board){
        return 0;
    }
}
