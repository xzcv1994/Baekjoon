package baek.num1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int L, C = 0;
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        String[] arr = new String[C];
        char[] arr2 = new char[L];
        for(int i=0; i<C; i++)
            arr[i] = sc.next();

        Arrays.sort(arr);

      for(int i=0; i<=C-L ; i++){
          arr2[0] = arr[i].charAt(0);
          pick(C-1, L-1, i+1, 1, arr2, arr);
      }
    }

    public static void pick(int n, int k, int head, int cnt, char[] carr, String[] sarr){
        if(k == 0){
            if(checker(carr)) {
                for (char c : carr)
                    System.out.print(c);
                System.out.println();
            }
            return;
        }

        for(int i = head; i<sarr.length; i++){
            carr[cnt] = sarr[i].charAt(0);
            pick(n-1, k-1, i+1, cnt+1, carr, sarr);
        }
        return;
    }

    public static boolean checker(char[] arr){
        int i = 0, k = 0;

        for(char c: arr) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    i++;
                    break;
                default:
                    k++;
                    break;
            }
        }
        return ((i>=1) && (k>=2));
    }
}
