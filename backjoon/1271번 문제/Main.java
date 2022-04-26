import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        BigInteger money = new BigInteger(data[0]);
        BigInteger count = new BigInteger(data[1]);
        System.out.println(money.divide(count));
        System.out.println(money.remainder(count));
    }
}