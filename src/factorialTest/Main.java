package factorialTest;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger num = new BigInteger("1");

        for(int i =1; i<=35; i++){
            num = num.multiply(new BigInteger(i + ""));
        }
        System.out.println(num);
    }
}
