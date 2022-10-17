import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String numbers = br.readLine();
        StringTokenizer st = new StringTokenizer(numbers);
        int totalNumber = 0;
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            totalNumber+=number*number;
        }
        System.out.println(totalNumber%10);
    }
}
