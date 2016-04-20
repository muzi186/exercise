package corejava.math;

import java.math.BigInteger;

/**
 * Created by gavin on 16-3-17.
 */
public class BigIntegerDemo {
    public static void main(String... args){
        String numA = "333111111111222222222333333333444444444555555555666666666777777777888888888999999999";
        String numB = "55555555555555555555555555555555555555555555555555555";

        BigInteger bigInt1 = new BigInteger(numA);
        BigInteger bigInt2 = new BigInteger(numB);

        BigInteger addResult = bigInt1.add(bigInt2);

        System.out.println(addResult);

        BigInteger multiResult = bigInt1.multiply(bigInt2);
        System.out.println(multiResult);
    }
}
