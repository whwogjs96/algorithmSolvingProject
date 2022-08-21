import java.io.*;

public class Main {

    public static final int MAX = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNumber = Integer.parseInt(br.readLine());
        int resultNumber = firstNumber;
        int resultCount = 0;
        do {
            int one , ten;
            ten = resultNumber/10;
            if(resultNumber < 10) {
                resultNumber = resultNumber*10+resultNumber;
            } else {
                one = resultNumber%10;
                resultNumber = (one + ten)%10 + one*10;
            }
            resultCount++;
        }while (firstNumber != resultNumber);
        System.out.println(resultCount);
    }
}