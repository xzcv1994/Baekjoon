package num2047;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static BigInteger[][] dp = new BigInteger[101][101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        System.out.println(com(n,m));
    }

    public static BigInteger com(int n, int r){
        if(dp[n][r] != null) {
            return dp[n][r];
        }

        if(n == r || r == 0){
            return new BigInteger("1");
        }

        return dp[n][r] = com(n-1, r-1).add(com(n-1, r));
    }
}
