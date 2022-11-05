import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int x = Integer.parseInt(numbers[0]);
        int y = Integer.parseInt(numbers[1]);
        int minX = Math.min(Math.abs(x - Integer.parseInt(numbers[2])), x);
        int minY = Math.min(Math.abs(y - Integer.parseInt(numbers[3])), y);
        System.out.println(Math.min(minX, minY));
    }
}