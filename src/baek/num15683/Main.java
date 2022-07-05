package baek.num15683;

import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static boolean[][] tempMap;
    public static int[] way;
    public static int Min = 100;
    public static int camNum = 0;
    public static int N, M;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][M+1];
        tempMap = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            for(int j =1; j<=M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j] != 6 && map[i][j] != 0)
                    camNum++;
            }
        }

        way = new int[camNum+1];
        choice(0);
        System.out.println(Min);
    }

    public static void choice(int cnt){
        if(cnt == camNum){
            simulation();
            tempMap = new boolean[N+1][M+1];
            return;
        }

        for(int i=1; i<5; i++){
            way[cnt+1] = i;
            choice(cnt+1);
        }
    }

    public static void simulation(){
        int cnt = 1;
        int blind = 0;
        int temp;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                temp = map[i][j];
                if(temp != 6 && temp != 0){
                    if(temp == 1)
                        cam1(way[cnt++],i,j);
                    else if(temp == 2)
                        cam2(way[cnt++],i,j);
                    else if(temp == 3)
                        cam3(way[cnt++],i,j);
                    else if(temp == 4)
                        cam4(way[cnt++],i,j);
                    else if(temp == 5)
                        cam5(way[cnt++],i,j);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
               if(!tempMap[i][j] && (map[i][j] == 0))
                   blind++;
            }
        }

        Min = blind <= Min ? blind : Min;
    }

    public static void cam1(int way, int n, int m){
        if(way == 1){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
        }

        if(way == 2){
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }

        if(way == 3){
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
        }

        if(way == 4){
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }
    }

    public static void cam2(int way, int n, int m){
        if(way == 1 || way == 3){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
        }

        if(way == 2 || way == 4){
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }
    }

    public static void cam3(int way, int n, int m){
        if(way == 1){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }

        if(way == 2){
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
        }

        if(way == 3){
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }

        if(way == 4){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }
    }

    public static void cam4(int way, int n, int m){
        if(way == 1){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }

        if(way == 2){
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
        }

        if(way == 3){
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
            for(int i=m+1; i<=M; i++){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }

        if(way == 4){
            for(int i=n+1; i<=N; i++){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=n-1; i>0; i--){
                if(map[i][m] == 6)
                    break;
                tempMap[i][m] = true;
            }
            for(int i=m-1; i>0; i--){
                if(map[n][i] == 6)
                    break;
                tempMap[n][i] = true;
            }
        }
    }

    public static void cam5(int way, int n, int m){
        for(int i=n+1; i<=N; i++){
            if(map[i][m] == 6)
                break;
            tempMap[i][m] = true;
        }
        for(int i=n-1; i>0; i--){
            if(map[i][m] == 6)
                break;
            tempMap[i][m] = true;
        }
        for(int i=m-1; i>0; i--){
            if(map[n][i] == 6)
                break;
            tempMap[n][i] = true;
        }
        for(int i=m+1; i<=M; i++){
            if(map[n][i] == 6)
                break;
            tempMap[n][i] = true;
        }
    }
}
