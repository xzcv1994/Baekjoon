package num1010;

import java.util.Scanner;

public class Main {
    static int count = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long[] arr = new long[t];
        long[][] dp = new long[31][31];
        long count = 0;

        for(int i=0; i<t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 1){
                arr[i] = m;
                continue;
            }

            for(int j=n-1; j<=m-1; j++){
                count += solution(j, n-1, dp);
            }
            arr[i] = count;
            count = 0;
        }

        for(int i=0; i<t; i++)
            System.out.println(arr[i]);
    }

    public static long solution(int front, int rear, long[][] dp){
       if(front == rear){
           dp[front][rear] = 1;
           return 1;
       } else if(rear == 1){
           dp[front][rear] = front;
           return front;
       }

       if(dp[front][rear] == 0)
            dp[front][rear] = solution(front-1, rear -1, dp) + solution(front-1, rear, dp);

       return dp[front][rear];
    }
}
