package baek.num14501;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int dp[] = new int[21];
        int t[] = new int[16];
        int p[] = new int[1001];
        int n = sc.nextInt();
        int max = 0;

        for(int i=1; i<=n; i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for(int i=n; i>=1; i--){
            if(i + t[i] <= n+1){
                dp[i] = dp[i + t[i]] + p[i];
            }
            else{
                dp[i] = 0;
            }
            if(max > dp[i]){
                dp[i] = max;
            }
            else{
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
