package baek.num14889;

import java.util.Scanner;

public class Main {
    public static int[][] arr;
    public static boolean[] pick;
    public static int N;
    public static int min = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N+1][N+1];
        pick = new boolean[N + 1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 1);

        System.out.println(min);
    }

    public static void dfs(int cnt, int head){
       if(cnt == N/2){
          diff();
          return;
       }

       for(int i = head; i<=N; i++){
           pick[i] = true;
           dfs(cnt+1, i+1);
           pick[i] = false;
       }
    }

    public static void diff(){
        int teamA = 0, teamB = 0;

        for(int i=1; i<=N; i++){
                for (int j = i+1; j <= N; j++) {
                 if(pick[i] && pick[j]){
                     teamA += arr[i][j];
                     teamA += arr[j][i];
                 }
                 else if(!pick[i] && !pick[j]){
                     teamB += arr[i][j];
                     teamB += arr[j][i];
                 }
            }
        }

        min = Math.min(Math.abs(teamA - teamB), min);
    }
}
