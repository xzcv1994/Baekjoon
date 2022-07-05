package baek.num16234;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int N;
    public static int L;
    public static int R;
    public static int day = 0;
    public static int[][] map;
    public static boolean[][] countryPick;
    public static List<Union> unionList;
    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N+1][N+1];

        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        while(check()){
            day++;
            for(Union u : unionList){
                move(u);
            }
        }

        System.out.println(day);
    }

    public static boolean check(){
        unionList = new ArrayList<>();
        countryPick = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(!countryPick[i][j]){
                    Union u = new Union();
                    Country firstCountry = new Country(i, j);
                    u.list.add(firstCountry);
                    search(i, j, u);
                }
            }
        }

        //연합이 하나라도 들어있으면 true지 이미 밑에서 국가가 2개이상인 연합 체크는 했으니까
        return (unionList.size() >= 1) ? true : false;
    }

    public static void search(int r, int c, Union u){
        int sub = 0;
        countryPick[r][c] = true;

        for(int i=0; i<4; i++){
            if(r+dr[i]>0 && c+dc[i]>0 && r+dr[i]<=N && c+dc[i]<=N) {
                sub = Math.abs(map[r][c] - map[r + dr[i]][c + dc[i]]);

                if (L <= sub && sub <= R && !countryPick[r+dr[i]][c+dc[i]]) {
                    Country country = new Country(r + dr[i], c + dc[i]);
                    u.list.add(country);
                    search(r + dr[i], c + dc[i], u);
                }
            }
        }

        //여기서 이미 한번 국가가 2개 이상인 연합 체크를 해서 연합 리스트에 넣었는데 위해서 연합 리스트에 있는 연합 대상으로 체크하는 실수
        //이미 연합의 조건을 만족하는지 체크 함
        if(u.list.size() > 1){
            unionList.add(u);
        }
    }

    public static void move(Union u){
        int num = u.list.size();
        int sum = 0;
        int people;

        for(Country c : u.list){
            sum += map[c.r][c.c];
        }

        people = sum/num;

        for(Country c : u.list){
            map[c.r][c.c] = people;
        }
    }

    public static class Union{
        List<Country> list = new ArrayList<>();
    }

    public static class Country{
        int r;
        int c;

        public Country(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
