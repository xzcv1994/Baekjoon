package num11050;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n, k = 0;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        System.out.println(factorial(n)/(factorial(n-k) * factorial(k)));
    }

    public static int factorial(int k){
        if(k == 0 || k == 1){
            return 1;
        }

        return k*factorial(k-1);
    }
}
