package baek.num9461;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long dp[] = new long[101];
        int t = sc.nextInt();
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i=1; i<=t; i++)
        {
            int n = sc.nextInt();
            if(n > 5){
                for(int j=6; j<=n; j++) {
                    dp[j] = dp[j - 5] + dp[j - 1];
                }
            }
            System.out.println(dp[n]);
        }
    }
}
