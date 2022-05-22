package num14888;

import java.util.Scanner;

public class Main {
    public static long max = -1000000000;
    public static long min = 1000000000;
    public static int[] numArr;
    public static int[] calArr = new int[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        numArr = new int[N];

        for(int i=0; i<N; i++)
            numArr[i] = sc.nextInt();

        for(int i=0; i<4; i++)
            calArr[i] = sc.nextInt();

        solution(numArr[0],1, calArr[0], calArr[1], calArr[2], calArr[3]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void solution (int num, int depth, int p, int s, int m, int d){
        int tempNum = num;
        if(p > 0){
            tempNum = num;
            tempNum += numArr[depth];
            solution(tempNum, depth+1, p-1, s,m,d);
        }

        if(s > 0){
            tempNum = num;

            tempNum -= numArr[depth];

            solution(tempNum, depth+1, p, s-1,m,d);

        }

        if(m > 0){
            tempNum = num;

            tempNum *= numArr[depth];

            solution(tempNum, depth+1, p, s,m-1,d);
        }

        if(d > 0){
            tempNum = num;

            if(tempNum > 0) {
                tempNum /= numArr[depth];

            }
            else{
                tempNum *= -1;
                tempNum /= numArr[depth];
                tempNum *= -1;
            }

            solution(tempNum, depth+1, p, s,m,d-1);
        }

        if(p == 0 && s == 0 && m == 0 && d == 0){
            if(tempNum >= max){
                max = tempNum;
            }

            if(tempNum <= min){
                min = tempNum;
            }
            return;
        }
    }
}
