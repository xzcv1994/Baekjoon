//import java.util.*;
//
//class Solution {
//    public int n;
//    public int[] dp = new int[10001];
//    public int coinChange(int[] coins, int amount) {
//        if(amount == 0){
//            return 0;
//        }
//
//        for(int i=1; i<=amount; i++){
//            int min = 10001;
//            int temp = 10001;
//            for(int j=0; j<coins.length; j++){
//                if(i - coins[j] >= 0){
//                    temp = dp(i - coins[j], coins);
//                    min = (min >= temp) ? temp : min;
//                }
//
//            }
//            if(min != 10001){
//                dp[i] = min+1;
//            }
//        }
//
//
//        if(dp[amount] == 0)
//            return -1;
//
//        return dp[amount];
//    }
//
//    public int dp(int amount, int[] coins){
//        if(amount == 0){
//            return 0;
//        }
//        else if(amount > 0 && dp[amount] != 0){
//            return dp[amount];
//        }
//        return 10001;
//    }
//}