package baek.num10973;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=N-1; i>0; i--){
            if(arr[i] < arr[i-1]){
                arr[i-1] = solution(arr, arr[i-1], i-1);
                Arrays.sort(arr, i, N-1);
//                for(int j : arr){
//                    System.out.print(j + " ");
//                }
                reverse(arr, i, N-1);
                for(int j : arr){
                    System.out.print(j + " ");
                }
                return;
            }
        }

        System.out.println(-1);
    }

    public static int solution(int[] arr, int targetNum, int targetIndex){
//        System.out.println("targetNum : " + targetNum + ", targetIndex : " + targetIndex);
        int min = 0, minIndex = 0;
        for(int i=targetIndex+1; i<arr.length; i++){
            if(arr[i] < targetNum && arr[i] > min){
                min = arr[i];
                minIndex = i;
//                System.out.println("min : " + min + ", minIndex : " + minIndex);
            }
        }
        arr[minIndex] = targetNum;
        return min;
    }

    public static void reverse(int[] arr, int from, int to){
        int temp = 0;
        int count = 0;
        int start = from, end = to;
//        System.out.println("start : " + start + ", end : " + end);

        while (count <= (end-start+1)/2){
            temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
            count++;
        }
    }
}
