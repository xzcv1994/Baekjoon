package baek.num10972;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++)
            arr[i] = sc.nextInt();

        for(int i=N-1; i>0; i--){
            if(arr[i] > arr[i-1]){
                arr[i-1] = solution(arr[i-1], arr, i-1);
                Arrays.sort(arr, i, N);

                for(int j : arr){
                    System.out.print(j + " ");
                }
                return;
            }
        }
        System.out.println(-1);
    }

    public static int solution(int targetNum, int[] arr, int targetIndex){
        int min = 100000;
        int minIndex = 0;
        for(int i = targetIndex; i<arr.length; i++){
            if(arr[i] > targetNum && min > arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }
        arr[minIndex] = targetNum;
        return min;
    }
}
