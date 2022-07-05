package baek.num14890;

import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static boolean[][] road;
    public static boolean[][] roadB;
    public static boolean[][] tempRoad;
    public static int cntA = 0;
    public static boolean flag;
    public static boolean flagN;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        map = new int[N][N];
        road = new boolean[N][N];
        roadB = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){
            flagN = true;
            flag = false;
            tempRoad = new boolean[N][N];
            for(int j=0; j<N-1; j++){
                if(map[i][j] != map[i][j+1])
                    flagN = false;
//                System.out.println("f" + " r: " + i + " c : " + j);

                if((map[i][j] < map[i][j+1]) && (map[i][j+1] - map[i][j]) == 1){

                    flagN = false;
                    if(searchBehindRow(i,j,L,map[i][j])){
//                        System.out.println("g" + " r: " + i + " c : " + j);
                        flag = true;
                        makeBehindRoadRow(i,j,L,tempRoad);
                    }
                    else{
//                        System.out.println("b" + " r: " + i + " c : " + j);
//                        makeRoadZeroRow(i, tempRoad);
                        flag = false;
                        break;
                    }
                }

                if((map[i][j] > map[i][j+1]) && (map[i][j] - map[i][j+1]) == 1){
                    flagN = false;
                    if(searchFrontRow(i,j+1,L,map[i][j+1])){
//                        System.out.println("g" + " r: " + i + " c : " + j);
                        flag = true;
                        makeFrontRoadRow(i,j+1,L,tempRoad);
                    }
                    else{
//                        System.out.println("b" + " r: " + i + " c : " + j);
                        flag = false;
//                        makeRoadZeroRow(i, tempRoad);
                        break;
                    }
                }
            }
            if(flag){
                cntA++;
//                System.out.println("r : " + i);
               for(int k=0; k< road.length; k++){
                   road[i][k] = tempRoad[i][k];
               }
            }

            if(flagN)
                cntA++;
        }

        for(int i=0; i<N; i++){
            flagN = true;
            flag = false;
            tempRoad = new boolean[N][N];
            for(int j=0; j<N-1; j++){
                if(map[j][i] != map[j+1][i])
                    flagN = false;

                if((map[j][i] < map[j+1][i]) && (map[j+1][i] - map[j][i]) == 1){
                    flagN = false;
                    if(searchBehindCol(j,i,L,map[j][i])){
                        flag = true;
                        makeBehindRoadCol(j,i,L,tempRoad);
                    }
                    else{
                        flag = false;
//                        makeRoadZeroCol(j, tempRoad);
                        break;
                    }
                }

                if((map[j][i] > map[j+1][i]) && (map[j][j] - map[j+1][i]) == 1){
                    flagN = false;
                    if(searchFrontCol(j+1,i,L,map[j+1][i])){
                        flag = true;
                        makeFrontRoadCol(j+1,i,L,tempRoad);
                    }
                    else{
                        flag = false;
//                        makeRoadZeroCol(j, tempRoad);
                        break;
                    }
                }
            }
            if(flag){

                cntA++;
                for(int k=0; k< roadB.length; k++){
                    roadB[k][i] = tempRoad[k][i];
                }
            }

            if(flagN)
                cntA++;
        }
        System.out.println(cntA);

    }

    public static boolean searchFrontRow(int r, int c, int L, int height){
        int cnt = 0;
        for(int i = c; i<map.length; i++){
            if(height == map[r][i] && !road[r][i] && !tempRoad[r][i]){
                cnt++;
            }
            else{
                break;
            }
        }
        return (cnt >= L) ? true : false;
    }

    public static boolean searchBehindRow(int r, int c, int L, int height){
        int cnt = 0;
        for(int i = c; i>=0; i--){
//            System.out.println("s" + " r: " + r + " c : " + i);

            if(height == map[r][i] && !road[r][i] && !tempRoad[r][i]){

                cnt++;
            }
            else{
                break;
            }
        }
        return (cnt >= L) ? true : false;
    }

    public static boolean searchFrontCol(int r, int c, int L, int height){
        int cnt = 0;
        for(int i = r; i<map.length; i++){
            if(height == map[i][c] && !roadB[i][c] && !tempRoad[i][c]){
                cnt++;
            }
            else{
                break;
            }
        }
        return (cnt >= L) ? true : false;
    }

    public static boolean searchBehindCol(int r, int c, int L, int height){
        int cnt = 0;
        for(int i = r; i>=0; i--){
            if(height == map[i][c] && !roadB[i][c] && !tempRoad[i][c]){
                cnt++;
            }
            else{
                break;
            }
        }
        return (cnt >= L) ? true : false;
    }

    public static void makeBehindRoadRow(int r, int c, int L, boolean[][] road){
        while(true){
            if(L==0) break;

            road[r][c] = true;
            c--;
            L--;
        }
    }

    public static void makeFrontRoadRow(int r, int c, int L, boolean[][] road){
        while(true){
            if(L==0) break;

            road[r][c] = true;
            c++;
            L--;
        }
    }

    public static void makeBehindRoadCol(int r, int c, int L, boolean[][] road){
        while(true){
            if(L==0) break;

            road[r][c] = true;
            r--;
            L--;
        }
    }

    public static void makeFrontRoadCol(int r, int c, int L, boolean[][] road){
        while(true){
            if(L==0) break;

            road[r][c] = true;
            r++;
            L--;
        }
    }

    public static void makeRoadZeroRow(int r, boolean[][] road){
        for(int i=0;i<road.length;i++){
            road[r][i] = false;
        }
    }

    public static void makeRoadZeroCol(int c, boolean[][] road){
        for(int i=0;i<road.length;i++){
            road[i][c] = false;
        }
    }
}
