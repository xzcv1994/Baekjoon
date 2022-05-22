package num14503;

import java.util.Scanner;

public class Main {
    public static boolean[][] check;
    public static int[][] map;
    public static int[] dr = {0,0,1,-1};
    public static int[] dc = {1,-1,0,0};
    public static int cnt = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m, r, c, d;
        n= sc.nextInt();
        m= sc.nextInt();
        r= sc.nextInt();
        c= sc.nextInt();
        d= sc.nextInt();

        check = new boolean[n+1][m+1];
        map = new int[n+1][m+1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        check[r][c] = true;
        clean(r, c, d);

        System.out.println(cnt);
    }

    public static void clean(int r, int c, int d){
        while(true){
            int curR = r;
            int curC = c;

            if(d == 0){
               if(searchW(curR, curC)){
                   r += dr[1];
                   c += dc[1];
                   d = 3;
                   continue;
               }
               if(searchS(curR, curC)){
                   r += dr[2];
                   c += dc[2];
                   d = 2;
                   continue;
               }
               if(searchE(curR, curC)){
                   r += dr[0];
                   c += dc[0];
                   d = 1;
                   continue;
               }
               if(searchN(curR, curC)){
                   r += dr[3];
                   c += dc[3];
                   d = 0;
                   continue;
               }
            }
            else if(d == 1){
                if(searchN(curR, curC)){
                    r += dr[3];
                    c += dc[3];
                    d = 0;
                    continue;
                }
                if(searchW(curR, curC)){
                    r += dr[1];
                    c += dc[1];
                    d = 3;
                    continue;
                }
                if(searchS(curR, curC)){
                    r += dr[2];
                    c += dc[2];
                    d = 2;
                    continue;
                }
                if(searchE(curR, curC)){
                    r += dr[0];
                    c += dc[0];
                    d = 1;
                    continue;
                }
            }
            else if(d == 2){
                if(searchE(curR, curC)){
                    r += dr[0];
                    c += dc[0];
                    d = 1;
                    continue;
                }
                if(searchN(curR, curC)){
                    r += dr[3];
                    c += dc[3];
                    d = 0;
                    continue;
                }
                if(searchW(curR, curC)){
                    r += dr[1];
                    c += dc[1];
                    d = 3;
                    continue;
                }
                if(searchS(curR, curC)){
                    r += dr[2];
                    c += dc[2];
                    d = 2;
                    continue;
                }
            }
            else if(d == 3){
                if(searchS(curR, curC)){
                    r += dr[2];
                    c += dc[2];
                    d = 2;
                    continue;
                }
                if(searchE(curR, curC)){
                    r += dr[0];
                    c += dc[0];
                    d = 1;
                    continue;
                }
                if(searchN(curR, curC)){
                    r += dr[3];
                    c += dc[3];
                    d = 0;
                    continue;
                }
                if(searchW(curR, curC)){
                    r += dr[1];
                    c += dc[1];
                    d = 3;
                    continue;
                }
            }

            curR = r;
            curC = c;

            if(d==0){
                curR++;
                if(map[curR][curC] != 1) {
                    r = curR;
                    c = curC;
                    continue;
                }
            }
            else if(d==1){
                curC--;
                if(map[curR][curC] != 1){
                    r=curR;
                    c=curC;
                    continue;
                }
            }
            else if(d==2){
                curR--;
                if(map[curR][curC] != 1){
                    r=curR;
                    c=curC;
                    continue;
                }
            }
            else if(d==3){
                curC++;
                if(map[curR][curC] != 1){
                    r=curR;
                    c=curC;
                    continue;
                }
            }
            break;
        }
    }

    public static boolean searchN(int r, int c){
        r += dr[3];
        c += dc[3];
        if(check[r][c] == false && map[r][c] != 1){
            check[r][c] = true;
            cnt++;
            return true;
        }
        else
            return false;
    }
    public static boolean searchE(int r, int c){
        r += dr[0];
        c += dc[0];
        if(check[r][c] == false && map[r][c] != 1){
            check[r][c] = true;
            cnt++;
            return true;
        }
        else
            return false;
    }
    public static boolean searchS(int r, int c){
        r += dr[2];
        c += dc[2];
        if(check[r][c] == false && map[r][c] != 1){
            check[r][c] = true;
            cnt++;
            return true;
        }
        else
            return false;
    }
    public static boolean searchW(int r, int c){
        r += dr[1];
        c += dc[1];
        if(check[r][c] == false && map[r][c] != 1){
            check[r][c] = true;
            cnt++;
            return true;
        }
        else
            return false;
    }
}
