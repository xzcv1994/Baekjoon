package baek.num15685;

import java.util.*;

public class Main {
    public static Point endPoint;
    public static int cnt = 0;
    public static List<Point> allArr = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] info;
        int n;
        List<Point> arr = new ArrayList<>();
        n = sc.nextInt();
        info = new int[n+1][5];

        for(int i=1; i<=n; i++){
            info[i][1] = sc.nextInt();
            info[i][2] = sc.nextInt();
            info[i][3] = sc.nextInt();
            info[i][4] = sc.nextInt();
        }

        for(int i=1; i<=n; i++){
            arr.add(new Point(info[i][1],info[i][2]));
            addEndPoint(info[i][1],info[i][2],info[i][3], arr);

            for(int j=1; j<=info[i][4]; j++){
                move(arr);
            }

            for(Point p : arr){
                allArr.add(p);
            }
            arr = new ArrayList<>();
        }

        check();

        System.out.println(cnt);
    }

    public static void addEndPoint(int x, int y, int d, List<Point> arr){
        if(d == 0){
            arr.add(new Point(x+1, y));
            endPoint = new Point(x+1, y);
        }
        else if(d == 1){
            arr.add(new Point(x, y-1));
            endPoint = new Point(x, y-1);
        }
        else if(d == 2){
            arr.add(new Point(x-1, y));
            endPoint = new Point(x-1, y);
        }
        else if(d == 3){
            arr.add(new Point(x, y+1));
            endPoint = new Point(x, y+1);
        }
    }

    public static void move(List<Point> arr){
        int dx = endPoint.x;
        int dy = endPoint.y;
        List<Point> tempArr = new ArrayList<>();
        for(Point temp : arr){
            if(temp.x == endPoint.x && temp.y == endPoint.y)
                continue;

            int newX = (temp.y - dy) * -1 + dx;
            int newY = (temp.x - dx) + dy;
            Point newPoint = new Point(newX, newY);

            if(temp.x == arr.get(0).x && temp.y == arr.get(0).y){
                endPoint = newPoint;
            }
            tempArr.add(newPoint);
        }

        for(Point p : tempArr){
            arr.add(p);
        }
    }

    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void check(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(!check2(i,j))
                    continue;
                if(!check2(i+1,j))
                    continue;
                if(!check2(i,j+1))
                    continue;
                if(!check2(i+1,j+1))
                    continue;
                cnt++;
            }
        }
    }

    public static boolean check2(int x, int y){
        for(Point p : allArr) {
            if(p.x == x && p.y == y){
                return true;
            }
        }
        return false;
    }

}
