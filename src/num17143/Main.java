package num17143;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Shark[][] map;
    static Shark[][] moveMap;
    static int userPosition=0;
    static int R, C, M;
    static int sharkTotal=0;
    static List<Shark> sharkList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();
        int r,c,s,d,z;

        map = new Shark[R+1][C+1];
        moveMap = new Shark[R+1][C+1];

        for(int i = 1; i<=M; i++){
            r = sc.nextInt();
            c = sc.nextInt();
            s = sc.nextInt();
            d = sc.nextInt();
            z = sc.nextInt();

            map[r][c] = new Shark(r,c,s,d,z);
            sharkList.add(new Shark(r,c,s,d,z));
        }

        for(int i=1; i<=C; i++){
            fish();
            move();
        }

        System.out.println(sharkTotal);
    }

    public static void fish(){
        userPosition++;
        for(int i=1; i<=R; i++){
            if(map[i][userPosition] != null) {
                sharkTotal += map[i][userPosition].z;
                sharkList.remove(map[i][userPosition]);
                map[i][userPosition] = null;
                return;
            }
        }
    }

    public static void move(){
        List<Shark> removeList = new ArrayList<>();
        for(Shark s : sharkList){
            Shark temp = s;
            map[s.r][s.c] = null;

            if((s.d == 1 || s.d == 2) && s.s != 0)
                moveRow(temp);
            else if((s.d == 3 || s.d == 4) && s.s != 0)
                moveCol(temp);

            if(moveMap[temp.r][temp.c] != null){
                if((moveMap[temp.r][temp.c].z > temp.z)){
                    removeList.add(temp);
                }
                else{
                    removeList.add(moveMap[temp.r][temp.c]);
                    moveMap[temp.r][temp.c] = temp;
                }
            }
            else if(map[temp.r][temp.c] == null){
                moveMap[temp.r][temp.c] = temp;
            }
        }

        for(int i=1; i<=R; i++){
            for(int j=1; j<=C; j++){
                if(moveMap[i][j] != null)
                    map[i][j] = moveMap[i][j];
            }
        }

        for(Shark s : removeList){
            sharkList.remove(s);
        }
        moveMap = new Shark[R+1][C+1];
    }

    public static void moveRow(Shark s){
        for(int i=1; i<=s.s; i++){
            if(s.d == 1){
                if(s.r == 1 && s.d == 1){
                    s.d = 2;
                    if(s.r +1 <= R)
                        s.r++;
                    continue;
                }
                s.r--;
            }
            else if(s.d == 2){
                if(s.r == R && s.d == 2){
                    s.d = 1;
                    if(s.r - 1 >= 1)
                        s.r--;
                    continue;
                }
                s.r++;
            }
        }
    }

    public static void moveCol(Shark s){
        for(int i=1; i<=s.s; i++){
            if(s.d == 3){
                if(s.c == C && s.d == 3){
                    s.d = 4;
                    if(s.c - 1 >= 1)
                        s.c--;
                    continue;
                }
                s.c++;
            }
            else if(s.d == 4){
                if(s.c == 1 && s.d == 4){
                    s.d = 3;
                    if(s.c + 1 <= C)
                        s.c++;
                    continue;
                }
                s.c--;
            }
        }
    }

    public static class Shark{
        int r;
        int c;
        int s;
        int d;
        int z;
        boolean eliminated;

        public Shark(int r, int c, int s, int d, int z){
            this.r=r;
            this.c=c;
            this.s=s;
            this.d=d;
            this.z=z;
        }
    }
}
