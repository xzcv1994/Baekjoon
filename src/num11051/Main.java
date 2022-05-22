package num11051;

import java.util.Scanner;

public class Main {
    static int N, K;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int com = 0;
        N = sc.nextInt();
        K = sc.nextInt();
        int[][] dp = new int[N+1][K+1];
        boolean[][] check = new boolean[N+1][K+1];

        com = combination(N, K, dp, check);
        System.out.print(com);
    }

    public static int combination(int n, int k, int[][] dp, boolean[][] check){
        if(check[n][k] == true) {
            return dp[n][k];
        }

        if(k == 0 || n == k) {
            return 1;
        }

        dp[n][k] = (combination(n-1, k-1, dp, check) + combination(n-1, k, dp, check)) % 10007;
        check[n][k] = true;
        return dp[n][k];
    }
}
