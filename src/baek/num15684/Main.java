package baek.num15684;

import java.util.Scanner;

public class Main {
    public static int Min = 5;
    public static int[][] line;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, H;
        int tempN, tempM;

        N = sc.nextInt();
        M = sc.nextInt();
        H = sc.nextInt();

        line = new int[N+1][H+1];

        for(int i=0; i<M; i++){
            tempN = sc.nextInt();
            tempM = sc.nextInt();

            // 1 : 오른쪽선, 2 : 왼쪽선
            line[tempN][tempM] = 1;
            line[tempN][tempM+1] = 2;
        }

    }

    public static void move(){

    }

    public static int check(int n, int m){
        if(line[n][m] == 1)
            return 1;
        else if(line[n][m] == 2)
            return 2;
        else
            return 0;
    }
}
