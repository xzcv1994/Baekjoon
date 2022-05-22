package num16236;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int N;
    public static List<Point> list = new ArrayList<>();
    public static List<Point> realList = new ArrayList<>();
    public static boolean[][] check;
    public static int[][] map;
    public static int sharkSize = 2;
    public static Point sharkPosition;
    public static int sharkEat = 0;
    public static int moveTime = 0;
    public static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+1][N+1];
        check = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == 9){
                    sharkPosition = new Point(i, j);
                }
            }
        }

        while(search()){
            for(Point p : list){
                dfs(sharkPosition.r, sharkPosition.c, p.r, p.c, 0);
                flag = false;
            }

            if(realList.size() == 0)
                break;

            Point targetFish = distanceCal();
            sharkPosition.r = targetFish.r;
            sharkPosition.c = targetFish.c;
            map[targetFish.r][targetFish.c] = 0;
            sharkEat++;
            moveTime += targetFish.distance;
            if(sharkEat == sharkSize){
                sharkSize++;
                sharkEat = 0;
            }

            list = new ArrayList<>();
            realList = new ArrayList<>();
        }

        System.out.println(moveTime);

    }

    public static void dfs(int r, int c, int targetR, int targetC, int cnt){
        if(flag)
            return;

        if(targetR == r && targetC == c) {
            Point p = new Point(r,c);
            p.distance = cnt;
            isEmpty(p);

//            if(cnt == (Math.abs(sharkPosition.r - r) + Math.abs(sharkPosition.c - c)));
//                flag = true;

            return;
        }

        for(int i=0; i<4; i++){
            int tempR = r + dr[i];
            int tempC = c + dc[i];

            if(tempR >= 1 && tempC >= 1 && tempR <= N && tempC <= N && map[targetR][targetC] <= sharkSize && !check[tempR][tempC] ){
                check[tempR][tempC] = true;
                dfs(tempR, tempC, targetR, targetC, cnt+1);
                check[tempR][tempC] = false;
            }
        }
        return;
    }

    public static boolean search(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] < sharkSize && map[i][j] !=0){
                    list.add(new Point(i,j));
                }
            }
        }

        if(list.isEmpty())
            return false;

        return true;
    }


    public static Point distanceCal(){
        List<Point> minDistanceList = new ArrayList<>();
        List<Point> minRowList = new ArrayList<>();
        List<Point> minColList = new ArrayList<>();

        int min = 10000;

        if(realList.size() == 1) {
            return realList.get(0);
        }

        for(Point p : realList){
            min = min >= p.distance ? p.distance : min;
        }

        for(Point p : realList){
            if(min == p.distance)
                minDistanceList.add(p);
        }

        if(minDistanceList.size() == 1){
            return minDistanceList.get(0);
        }

        min = N;

        for(Point p : minDistanceList){
            min = min >= p.r ? p.r : min;
        }

        for(Point p : minDistanceList){
            if(min == p.r)
                minRowList.add(p);
        }

        if(minRowList.size() == 1){
            return minRowList.get(0);
        }

        min = N;

        for(Point p : minRowList){
            min = min >= p.c ? p.c : min;
        }

        for(Point p : minRowList){
            if(min == p.c)
                minColList.add(p);
        }

        return minColList.get(0);

    }

    public static void isEmpty(Point check){
        for(Point p : realList){
            if(p.isEqual(check)){
                if(p.distance <= check.distance) {
                    return;
                }
                else{
                    p.distance = check.distance;
                }
            }
        }
        realList.add(check);
    }

    public static class Point{
        int r;
        int c;
        int distance;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        public boolean isEqual(Point p){
            if(this.r == p.r && this.c == p.c)
                return true;
            else
                return false;
        }
    }
}
