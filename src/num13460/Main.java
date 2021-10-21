package num13460;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] board = new char[11][11];
    static int[][] rootCheck = new int[11][11];

    static Queue<Point> queueR = new LinkedList<>();
    static Queue<Point> queueB = new LinkedList<>();

    static Point curR = null;
    static Point curB = null;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N, M;
        String line;
        N = sc.nextInt();
        M = sc.nextInt();
        // nextInt(), next() 입력뒤에 nextLine()이 바로오면 왜인지 버그가 발생함
        // 이거 제거하기 위한 부분
        line = sc.nextLine();

        for(int i=1; i<=N; i++){
            line = sc.nextLine();
            for(int j=1; j<=M; j++){
                board[i][j] = line.charAt(j-1);
                if(board[i][j] == 'R'){
                    curR = new Point(i, j, 0, 'N');
                }
                else if(board[i][j] == 'B'){
                    curB = new Point(i, j, 0, 'N');
                }
            }
        }
        if(1 == searchR(curR)){
//            if(searchB(curB) != 1)
            return;
        }

        while(true){
            if(queueR.isEmpty()){
                System.out.println(-1);
                return;
            }

            if(-1 != moveR(queueR.poll())){
                break;
            }
        }
    }

    public static int searchR(Point cur){
        if('.' == board[cur.i-1][cur.j] && rootCheck[cur.i-1][cur.j] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'U'));
        }
        else if('.' == board[cur.i+1][cur.j] && rootCheck[cur.i+1][cur.j] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'D'));
        }
        else if('.' == board[cur.i][cur.j-1] && rootCheck[cur.i][cur.j-1] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'L'));
        }
        else if('.' == board[cur.i][cur.j+1] && rootCheck[cur.i][cur.j+1] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'R'));
        }

        if('O' == board[cur.i-1][cur.j] && rootCheck[cur.i-1][cur.j] == 0){
            System.out.println(cur.cnt+1);
            return 1;
        }
        else if('O' == board[cur.i+1][cur.j] && rootCheck[cur.i+1][cur.j] == 0){
            System.out.println(cur.cnt+1);
            return 1;
        }
        else if('O' == board[cur.i][cur.j-1] && rootCheck[cur.i][cur.j-1] == 0){
            System.out.println(cur.cnt+1);
            return 1;
        }
        else if('O' == board[cur.i][cur.j+1] && rootCheck[cur.i][cur.j+1] == 0){
            System.out.println(cur.cnt+1);
            return 1;
        }
        return -1;
    }

    public static void searchB(Point cur){
        if(('.' == board[cur.i-1][cur.j] || '0' == board[cur.i-1][cur.j]) && rootCheck[cur.i-1][cur.j] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'U'));
        }
        else if(('.' == board[cur.i+1][cur.j] || '0' == board[cur.i-1][cur.j]) && rootCheck[cur.i+1][cur.j] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'D'));
        }
        else if(('.' == board[cur.i][cur.j-1] || '0' == board[cur.i-1][cur.j]) && rootCheck[cur.i][cur.j-1] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'L'));
        }
        else if(('.' == board[cur.i][cur.j+1] || '0' == board[cur.i-1][cur.j]) && rootCheck[cur.i][cur.j+1] == 0){
            queueR.add(new Point(cur.i, cur.j, cur.cnt, 'R'));
        }
    }

    public static int moveR(Point p){
        int i = p.i;
        int j = p.j;
        board[i][j] = '.';
        p.cnt++;
        if(p.cnt > 10){
            System.out.println(-1);
            return 1;
        }
        if('U' == p.direction){
            while(true) {
                if ('.' == board[i-1][j]) {
                    i--;
                    rootCheck[i-1][j] = 1;
                } else if ('#' == board[i - 1][j]) {
                    board[i][j] = 'R';
                    break;
                } else if ('O' == board[i - 1][j]) {
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchR(new Point(i, j, p.cnt,'N'));
        }
        else if('D' == p.direction){
            while(true){
                if('.' == board[i+1][j]){
                    i++;
                    rootCheck[i-1][j] = 1;
                }
                else if('#' == board[i+1][j]){
                    board[i][j] = 'R';
                    break;
                }
                else if('O' == board[i+1][j]){
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchR(new Point(i, j, p.cnt,'N'));
        }
        else if('L' == p.direction){
            while(true){
                if('.' == board[i][j-1]){
                    j--;
                    rootCheck[i][j-1] = 1;
                }
                else if('#' == board[i][j-1]){
                    board[i][j] = 'R';
                    break;
                }
                else if('O' == board[i][j-1]){
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchR(new Point(i, j, p.cnt,'N'));
        }
        else if('R' == p.direction){
            while(true){
                if('.' == board[i][j+1]){
                    j++;
                    rootCheck[i][j+1] = 1;
                }
                else if('#' == board[i][j+1]){
                    board[i][j] = 'R';
                    break;
                }
                else if('O' == board[i][j+1]){
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchR(new Point(i, j, p.cnt,'N'));
        }
        return -1;
    }

    public static int moveB(Point p){
        int i = p.i;
        int j = p.j;
        board[i][j] = '.';
        p.cnt++;
        if(p.cnt > 10){
            System.out.println(-1);
            return 1;
        }
        if('U' == p.direction){
            while(true) {
                if ('.' == board[i-1][j]) {
                    i--;
                } else if ('#' == board[i - 1][j]) {
                    break;
                } else if ('O' == board[i - 1][j]) {
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchB(new Point(i, j, p.cnt,'N'));
        }
        else if('D' == p.direction){
            while(true){
                if('.' == board[i+1][j]){
                    i++;
                }
                else if('#' == board[i+1][j]){
                    break;
                }
                else if('O' == board[i+1][j]){
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchB(new Point(i, j, p.cnt,'N'));
        }
        else if('L' == p.direction){
            while(true){
                if('.' == board[i][j-1]){
                    j--;
                }
                else if('#' == board[i][j-1]){
                    break;
                }
                else if('O' == board[i][j-1]){

                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchB(new Point(i, j, p.cnt,'N'));
        }
        else if('R' == p.direction){
            while(true){
                if('.' == board[i][j+1]){
                    j++;
                }
                else if('#' == board[i][j+1]){
                    break;
                }
                else if('O' == board[i][j+1]){
                    System.out.println(p.cnt);
                    return 1;
                }
            }
            searchB(new Point(i, j, p.cnt,'N'));
        }
        return -1;
    }

    static class Point{
        int i;
        int j;
        int cnt;
        char direction;

        public Point(int i, int j, int cnt, char direction){
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.direction = direction;
        }
    }
}
