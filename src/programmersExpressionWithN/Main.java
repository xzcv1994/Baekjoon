import java.util.*;

class Main {
    List<Integer> arr[] = new List[10];
    public int solution(int N, int number) {
        List<Integer> temp = new ArrayList<>();
        temp.add(N);
        arr[1] = temp;

        for(int i=2; i<=8; i++){
            makeNumber(i, N);
        }

        for(int i=1; i<=8; i++){
            for(int a : arr[i]){
                if(a == number)
                    return i;
            }
        }
        return -1;
    }

    public void makeNumber(int i, int N){
        List<Integer> temp1 = new ArrayList<>();
        int temp = 0;

        for(int j=1; j<=i; j++){
            temp = 10 * temp + N;
        }

        temp1.add(temp);

        for(int j=1; j<i; j++){
            for(int a : arr[j]){
                for(int b : arr[i-j]){
                    temp1.add(a+b);
                    temp1.add(a-b);
                    temp1.add(a*b);
                    if(b != 0)
                        temp1.add(a/b);
                }
            }
        }
        arr[i] = temp1;
    }
}