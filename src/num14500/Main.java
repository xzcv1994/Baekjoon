package num14500;

import java.util.*;

public class Main {
    static int[][] paper = new int[501][501];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,m;
        int limitN, limitM;
        int max = 0;
        int sum = 0;

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        for(int k=1; k<=19; k++){
            limitN = getLimitN(n, k);
            limitM = getLimitM(m, k);

            for(int i=1; i<=limitM; i++){
                for(int j=1; j<=limitN; j++){
                    sum = getSum(k,j,i);
                    max = sum > max ? sum : max;
                }
            }
        }
        System.out.println(max);
    }

    public static int getLimitN(int n, int num){
        switch (num){
            case 1:
                return n;
            case 3:
            case 6:
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 19:
                return n-1;
            case 4:
            case 5:
            case 7:
            case 10:
            case 12:
            case 13:
            case 17:
            case 18:
                return n-2;
            case 2:
                return n-3;
            default:
                return 0;
        }
    }

    public static int getLimitM(int m, int num){
        switch (num){
            case 2:
                return m;
            case 3:
            case 4:
            case 5:
            case 7:
            case 10:
            case 12:
            case 13:
            case 17:
            case 18:
                return m-1;
            case 6:
            case 8:
            case 9:
            case 11:
            case 14:
            case 15:
            case 16:
            case 19:
                return m-2;
            case 1:
                return m-3;
            default:
                return 0;
        }
    }

    public static int getSum(int k, int n, int m){
        switch(k){
            case 1:
                return paper[n][m]+ paper[n][m+1] + paper[n][m+2] + paper[n][m+3];
            case 2:
                return paper[n][m] + paper[n+1][m] + paper[n+2][m] +paper[n+3][m];
            case 3:
                return paper[n][m] + paper[n][m+1] + paper[n+1][m] + paper[n+1][m+1];
            case 4:
                return paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+2][m+1];
            case 5:
                return paper[n][m+1] + paper[n+1][m+1] + paper[n+2][m+1] + paper[n+2][m];
            case 6:
                return paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m];
            case 7:
                return paper[n][m] + paper[n][m+1] + paper[n+1][m+1] + paper[n+2][m+1];
            case 8:
                return paper[n+1][m] +paper[n+1][m+1]+ paper[n+1][m+2] + paper[n][m+2];
            case 9:
                return paper[n][m] + paper[n+1][m] + paper[n+1][m+1] + paper[n+1][m+2];
            case 10:
                return paper[n][m] + paper[n][m+1] + paper[n+1][m] + paper[n+2][m];
            case 11:
                return paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m+2];
            case 12:
                return paper[n][m] + paper[n+1][m] + paper[n+1][m+1] + paper[n+2][m+1];
            case 13:
                return paper[n][m+1] + paper[n+1][m] + paper[n+2][m] + paper[n+1][m+1];
            case 14:
                return paper[n+1][m] + paper[n+1][m+1] + paper[n][m+1] + paper[n][m+2];
            case 15:
                return paper[n][m] + paper[n][m+1] + paper[n+1][m+1] + paper[n+1][m+2];
            case 16:
                return paper[n][m] + paper[n][m+1] + paper[n][m+2] + paper[n+1][m+1];
            case 17:
                return paper[n][m] + paper[n+1][m] + paper[n+2][m] + paper[n+1][m+1];
            case 18:
                return paper[n+1][m] + paper[n][m+1] + paper[n+1][m+1] + paper[n+2][m+1];
            case 19:
                return paper[n+1][m] + paper[n+1][m+1] + paper[n][m+1] + paper[n+1][m+2];
            default:
                return 0;
        }
    }
}
