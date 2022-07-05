//package leet.leetCode70;
//
//public class Main {
//    public int cnt = 0;
//    public int step = 0;
//    public static void Main(String args_) {
//
//        Scanner sc = new Scanner(System.in);
//
//        if(!sc.hasNextInt())
//            step = sc.nextInt();
//
//        System.out.println("step : " + step);
//        dp(step);
//
//        System.out.println(cnt);
//        return cnt;
//    }
//
//    public void dp(int steps){
//        System.out.println(steps);
//        if(steps == 0){
//            cnt++;
//            return;
//        }
//
//        if(steps < 2){
//            dp(steps - 1);
//        }
//        else if(steps >= 2){
//            System.out.println("first");
//            dp(steps - 1);
//            System.out.println("second");
//            dp(steps - 2);
//        }
//
//        return;
//    }
//    }
//}
