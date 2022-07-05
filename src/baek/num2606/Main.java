package baek.num2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> queue = new LinkedList<>();
    static int map[][];
    static boolean check[];
    static int cnt = 0;
    public static void main(String[] args){
        int n, m, c1, c2;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n+1][n+1];
        check = new boolean[n+1];

        for(int i=0; i<m; i++){
            c1 = sc.nextInt();
            c2 = sc.nextInt();
            map[c1][c2] = 1;
            map[c2][c1] = 1;
        }

        queue.add(1);

        System.out.println(bfs(n));
    }

    public static int bfs(int n){

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i = 2; i<= n; i++){

                if(cur == i)
                    continue;

                if(map[cur][i] == 1 && check[i] == false){
                    cnt++;
                    queue.add(i);
                    map[cur][i] = 0;
                    map[i][cur] = 0;
                    check[i] = true;
                }
            }
        }
        return cnt;
    }
}
