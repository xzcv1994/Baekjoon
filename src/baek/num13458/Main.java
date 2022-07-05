package baek.num13458;

import java.util.Scanner;

public class Main {
    static int[] room = new int[1000001];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int b, c;
        long sum = 0;

        for(int i=1; i<=N; i++){
            room[i] = sc.nextInt();
        }

        b = sc.nextInt();
        c = sc.nextInt();

        for(int i=1; i<=N; i++){
            sum += solution(room[i], b, c);
        }

        System.out.println(sum);
    }

    public static int solution(int roomNum, int b, int c){
        int q, r;
        int temp = roomNum - b;

        if(temp <= 0){
            return 1;
        }

        q = temp/c;
        r = temp%c;

        if(q == 0){
            return 2;
        }
        else{
            if(r == 0)
                return 1 + q;
            else
                return 2 + q;
        }
    }
}
