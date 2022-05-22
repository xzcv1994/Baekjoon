package num1256;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Double.*;

public class Main {
    public static StringBuilder res = new StringBuilder();
    public static double[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M;
        double K;
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        dp = new double[N+1][M+1];

        getResult(N, M, K);

        if(check(N, M) < K){
            System.out.println(-1);
        }
        else{
            System.out.println(res.toString());
        }
    }
    public static void getResult(int a, int z, double k){
        double check;
        if(a==0){
            for(int i=z; i>0; i--){
                res.append("z");
            }
            return;
        }
        if(z==0){
            for(int i=a; i>0; i--){
                res.append("a");
            }
            return;
        }

        check = check(a-1, z);

        if(check > k){
            res.append("a");
            getResult(a-1, z, k);
        }
        else{
            res.append("z");
            getResult(a, z-1, k-check);
        }
    }

    public static double check(int a, int z){
        if(a == 0 || z == 0)
            return 1;

        if(dp[a][z] != 0)
            return dp[a][z];

        return dp[a][z]=Double.min(check(a-1,z)+check(a,z-1),1000000001);
    }
}
