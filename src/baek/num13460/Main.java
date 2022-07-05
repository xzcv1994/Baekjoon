package baek.num13460;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] board = new char[11][11];
    static boolean[][][][] visited = new boolean[11][11][11][11];
    static Queue<Point> queue = new LinkedList<>();
    static Point cur = null;
    static boolean redCheck, blueCheck;
    //상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N, M;
        String line;
        N = sc.nextInt();
        M = sc.nextInt();
        // nextInt(), next() 입력뒤에 nextLine()이 바로오면 왜인지 버그가 발생함
        // 이거 제거하기 위한 부분
        line = sc.nextLine();
        cur = new Point(0, 0, 0, 0,1);

        for(int i=1; i<=N; i++){
            line = sc.nextLine();
            for(int j=1; j<=M; j++){
                board[i][j] = line.charAt(j-1);
                if(board[i][j] == 'R'){
                    cur.rx = j;
                    cur.ry = i;
                }
                else if(board[i][j] == 'B'){
                    cur.bx = j;
                    cur.by = i;
                }
            }
        }
        queue.add(cur);
        System.out.println(bfs());
    }

    public static int bfs(){
        while(!queue.isEmpty()){
            Point point = queue.poll();

            visited[point.ry][point.rx][point.by][point.bx] = true;
            int curRx = point.rx;
            int curRy = point.ry;
            int curBx = point.bx;
            int curBy = point.by;
            int curCnt = point.cnt;

            for(int i=0; i<4; i++){
                int newRy = curRy;
                int newRx = curRx;
                int newBy = curBy;
                int newBx = curBx;
                redCheck = false;
                blueCheck = false;

                while(board[newRy + dy[i]][newRx + dx[i]] != '#'){
                    newRy = newRy + dy[i];
                    newRx = newRx + dx[i];

                    if(board[newRy][newRx] == 'O'){
                        redCheck = true;
                        break;
                    }
                }

                while(board[newBy + dy[i]][newBx + dx[i]] != '#'){
                    newBy = newBy + dy[i];
                    newBx = newBx + dx[i];

                    if(board[newBy][newBx] == 'O'){
                        blueCheck = true;
                        break;
                    }
                }

                if(blueCheck == true)
                    continue;

                if(redCheck == true && !blueCheck){
                    return curCnt;
                }

                if ((newRy == newBy) && (newRx == newBx)) {
                    if(i == 0){
                        if(curRy < curBy)
                            newBy += dy[i];
                        else
                            newRy += dy[i];
                    }
                    else if(i == 1){
                        if(curRy < curBy)
                            newRy -= dy[i];
                        else
                            newBy -= dy[i];
                    }
                    else if(i == 2){
                        if(curRx < curBx)
                            newBx += dx[i];
                        else
                            newRx += dx[i];
                    }
                    else if(i == 3){
                        if(curRx < curBx)
                            newRx -= dx[i];
                        else
                            newBx -= dx[i];
                    }
                }

                if(visited[newRy][newRx][newBy][newBx] == false){
                    visited[newRy][newRx][newBy][newBx] = true;
                    queue.add(new Point(newRy, newRx, newBy, newBx, curCnt+1));
                }
            }
        }
        return -1;
    }

    static class Point{
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Point(int i, int j, int iB, int jB, int cnt){
            this.ry = i;
            this.rx = j;
            this.by = iB;
            this.bx = jB;
            this.cnt = cnt;
        }
    }
}
