import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        long l = Long.parseLong(data, 16);
        System.out.println(l);
    }
}
