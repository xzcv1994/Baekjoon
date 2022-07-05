package baek.num17144;

import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int[][] addMap;
    public static int[][] rotateMap;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};
    public static int R;
    public static int C;
    public static int upSide = 0;
    public static int downSide = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R+1][C+1];
        addMap = new int[R+1][C+1];
        rotateMap = new int[R+1][C+1];
        int cnt = 0;

        int T = sc.nextInt();

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == -1 && upSide == 0)
                    upSide = i;
                else if(map[i][j] == -1 && upSide != 0)
                    downSide = i;
            }
        }

        for(int i = 1; i<=T; i++){
            round();
            add();
            cycle();
        }

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                cnt += map[i][j];
            }
        }

        System.out.println(cnt+2);
    }

    public static void round(){
        int howMany;
        int diffused;
        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(map[i][j] == -1)
                    continue;

                howMany = count(i, j);
                diffused = map[i][j]/5;
                map[i][j] = map[i][j] - diffused*howMany;
                diffuse(i,j,diffused);
            }
        }
    }

    public static void diffuse(int r, int c, int cnt){
        int tempR, tempC = 0;
        for(int i = 0; i<4; i++){
            tempR = r + dr[i];
            tempC = c + dc[i];

            if(1<=tempR && tempR<=R && 1<=tempC && tempC<=C && map[tempR][tempC] != -1){
                addMap[tempR][tempC] += cnt;
            }
        }
    }

    public static void add(){
        for(int i=1; i<=R; i++){
            for(int j=1; j<= C; j++){
                map[i][j] += addMap[i][j];
            }
        }
        addMap = new int[R+1][C+1];
    }

    public static int count(int r, int c){
        int tempR, tempC = 0;
        int cnt = 0;
        for(int i = 0; i<4; i++){
            tempR = r + dr[i];
            tempC = c + dc[i];

            if(1<=tempR && tempR<=R && 1<=tempC && tempC<=C && map[tempR][tempC] != -1){
                cnt++;
            }
        }
        return cnt;
    }

    public static void cycle(){
        for(int i=3; i<=C; i++){
            rotateMap[upSide][i] = map[upSide][i-1];
        }

        for(int i=upSide-1; i>=1; i--){
            rotateMap[i][C] = map[i+1][C];
        }

        for(int i=C-1; i>=1; i--){
            rotateMap[1][i] = map[1][i+1];
        }

        for(int i=2; i<upSide; i++){
            rotateMap[i][1] = map[i-1][1];
        }

        for(int i=3; i<=C; i++){
            rotateMap[downSide][i] = map[downSide][i-1];
        }

        for(int i=downSide+1; i<=R; i++){
            rotateMap[i][C] = map[i-1][C];
        }

        for(int i=C-1; i>=1; i--){
            rotateMap[R][i] = map[R][i+1];
        }

        for(int i=R-1; i>downSide; i--){
            rotateMap[i][1] = map[i+1][1];
        }

        rotateMap[upSide][2] = 0;
        rotateMap[downSide][2] = 0;

        for(int i=2; i<=C; i++){
            map[upSide][i] = rotateMap[upSide][i];
        }

        for(int i=upSide-1; i>=1; i--){
            map[i][C] = rotateMap[i][C];
        }

        for(int i=C-1; i>=1; i--){
            map[1][i] = rotateMap[1][i];
        }

        for(int i=2; i<upSide; i++){
            map[i][1] = rotateMap[i][1];
        }

        for(int i=2; i<=C; i++){
            map[downSide][i] = rotateMap[downSide][i];
        }

        for(int i=downSide+1; i<=R; i++){
            map[i][C] = rotateMap[i][C];
        }

        for(int i=C-1; i>=1; i--){
            map[R][i] = rotateMap[R][i];
        }

        for(int i=R-1; i>downSide; i--){
            map[i][1] = rotateMap[i][1];
        }

        map[upSide][1] = -1;
        map[downSide][1] = -1;

        rotateMap = new int[R+1][C+1];
    }
}
