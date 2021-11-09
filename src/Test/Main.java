package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int min = 1000;
    public static void main(String[] args) {
        test2();
        System.out.println(min);


//        int[] drinks = new int[10000];
//        int[] dp = new int[10000];
//
//        while(true){
//            Scanner sc = new Scanner(System.in);
//            int n = sc.nextInt();
//            int b,c,ans = 0;
//
//            for(int i=0; i<n; i++){
//                drinks[i] = sc.nextInt();
//            }
//
//            dp[0] = drinks[0];
//            dp[1] = drinks[0] + drinks[1];
//            dp[2] = get_max(dp[1], drinks[0] + drinks[2]);
//            dp[2] = get_max(dp[2], drinks[1] + drinks[2]);
//
//            for(int i=3; i<n; i++){
//                dp[i] = get_max(drinks[i] + drinks[i-1] + dp[i-3], drinks[i] + dp[i-2]);
//                dp[i] = get_max(dp[i-1], dp[i]);
//                ans = get_max(ans, dp[i]);
//            }
//            System.out.println(ans);
//            System.out.println("============");
//        }
//    }
//
//    public static int get_max(int a, int b){
//        return a>b ? a : b;
    }

    static void test2()
    {
        min = 4;
    }
}
