package num11401;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0, K = 0;

        N = sc.nextInt();
        K = sc.nextInt();
        int[][] dp = new int[N+1][K+1];

        System.out.println(combination(N, K, dp) % 1000000007);
    }

    public static int combination(int n, int r, int[][] dp){
        if(dp[n][r] !=0)
            return dp[n][r];

        if(n==r || r==0){
            return 1;
        }

        return dp[n][r] = combination(n-1, r-1, dp) + combination(n-1, r, dp);
    }
}
