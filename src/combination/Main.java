package combination;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        boolean[] visited = new boolean[size];

        for(int i=0; i<size; i++)
            arr[i] = i+1;


        for (int i = 1; i <= size; i++) {
            System.out.println("\n" + size + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, visited, 0, i);
        }
    }

    public static void combination(int[] arr, boolean[] visited, int start, int r){
        if(r == 0){
            print(arr, visited);
            return;
        }

        for(int i=start; i<arr.length; i++){
            visited[i] = true;
            combination(arr, visited, i + 1, r-1);
            visited[i] = false;
        }
    }

    public static void print(int[] arr, boolean[] visited){
        for(int i=0; i<arr.length; i++){
            if(visited[i] == true)
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
