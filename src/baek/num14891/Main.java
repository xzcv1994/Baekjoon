package baek.num14891;

import java.util.Scanner;

public class Main {
    public static int[][] gear;
    public static int[][] rotate;
    //0 : 무회전, 1 : 시계방향, -1 : 반시계방향
    public static int[] doRotate = new int[5];
    public static int motherRotate;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = "";
        int score = 0;
        gear = new int[5][9];

        for(int i=1; i<5; i++){
            str = sc.next();
            for(int j=0; j<8; j++){
                gear[i][j+1] = Character.getNumericValue(str.charAt(j));
            }
        }
        int rotateNum = sc.nextInt();
        rotate = new int[rotateNum+1][2];

        for(int i=1; i<=rotateNum; i++){
            rotate[i][0] = sc.nextInt();
            rotate[i][1] = sc.nextInt();
        }

        for(int i=1; i<=rotateNum; i++){
            doRotate = new int[5];
            doRotate[rotate[i][0]] = rotate[i][1];
            motherRotate = rotate[i][1];

            for(int j=rotate[i][0]; j>1; j--){
                if(check(j, j-1, true, false, motherRotate)) {
                    motherRotate *= -1;
                    doRotate[j-1] = motherRotate;
                } else{
                    break;
                }
            }

            motherRotate = rotate[i][1];
            for(int j=rotate[i][0]; j<4; j++){
                if(check(j, j+1, false, true, motherRotate)) {
                    motherRotate *= -1;
                    doRotate[j+1] = motherRotate;
                } else{
                    break;
                }
            }

            for(int j=1; j<5; j++){
                if(doRotate[j] == 1)
                    rotate(1, j);
                else if(doRotate[j] == -1)
                    rotate(-1, j);
            }
        }

        if(gear[1][1] == 0)
            score += 0;
        else if(gear[1][1] == 1)
            score += 1;

        if(gear[2][1] == 0)
            score += 0;
        else if(gear[2][1] == 1)
            score += 2;

        if(gear[3][1] == 0)
            score += 0;
        else if(gear[3][1] == 1)
            score += 4;

        if(gear[4][1] == 0)
            score += 0;
        else if(gear[4][1] == 1)
            score += 8;

        System.out.println(score);
    }

    public static boolean check(int motherGear, int sonGear, boolean left, boolean right, int way){
        if(left){
            if(gear[motherGear][7] != gear[sonGear][3]){
                return true;
            }
            else{
                return false;
            }
        }

        if(right){
            if(gear[motherGear][3] != gear[sonGear][7]){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    public static void rotate(int way, int gearNum){
        int tempArr[] = new int[9];
        if(way == 1){
            for(int i=1; i<9; i++){
                tempArr[i%8 + 1] = gear[gearNum][i];
            }
            for(int i=1; i<9; i++){
                gear[gearNum][i] = tempArr[i];
            }
        }
        else if(way == -1){
            tempArr[8] = gear[gearNum][1];
            for(int i=1; i<8; i++){
                tempArr[i] = gear[gearNum][i+1];
            }
            for(int i=1; i<9; i++){
                gear[gearNum][i] = tempArr[i];
            }
        }
    }
}
