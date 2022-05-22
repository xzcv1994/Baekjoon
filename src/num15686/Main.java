package num15686;

import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static List<Point> house = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static int minDistance = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == 1){
                    house.add(new Point(i, j));
                }
                else if(map[i][j] == 2){
                    chicken.add(new Point(i, j));
                }
            }
        }

        for(int i=1; i<=M; i++){
            for(int j=0; j <= (chicken.size()- i); j++){
                combination(j, i);
            }
        }

        System.out.println(minDistance);
    }

    public static void combination(int start, int limit){
        if(limit == 0){
            calculate();
            return;
        }

        for(int i = start; i<chicken.size(); i++){
            chicken.get(i).pick = true;
            combination(i+1, limit-1);
            chicken.get(i).pick = false;
        }
    }

    public static void calculate(){
        int distance;
        int distanceSum = 0;
        int min;

        for(Point h : house){
            min = 10000;
            for(Point c : chicken){
                if(!c.pick)
                    continue;

                distance = Math.abs(h.r - c.r) + Math.abs(h.c - c.c);
                if(min >= distance){
                    min = distance;
                }
            }
           distanceSum += min;
        }
       minDistance = (minDistance >= distanceSum) ? distanceSum : minDistance;
    }

    public static class Point {
        int r;
        int c;
        boolean pick = false;

        Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        public boolean equal(Point p){
            if(this.r == p.r && this.c == p.c){
                return true;
            }
            return false;
        }
    }
}
