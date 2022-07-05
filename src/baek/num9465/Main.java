package baek.num9465;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int n;
        long num1, num2;

        for(int i=1; i<=t; i++){
            n = sc.nextInt();
            int[][] arr = new int[3][100001];
            long[][] dp = new long[3][100001];

            for(int j=1; j<=2; j++) {
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1];
            dp[1][2] = arr[1][2] + dp[2][1];
            dp[2][2] = arr[2][2] + dp[1][1];

            for(int j=3; j<=n; j++){
                dp[1][j] = arr[1][j] + getMax(dp[2][j-1], dp[2][j-2]);
                dp[2][j] = arr[2][j] + getMax(dp[1][j-1], dp[1][j-2]);
            }
            System.out.println(getMax(dp[1][n], dp[2][n]));
        }
    }

    public static long getMax(long num1, long num2){
        return num1 >= num2 ? num1 : num2;
    }
}
