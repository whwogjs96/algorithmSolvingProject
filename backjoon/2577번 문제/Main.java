import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = 1;
        int []conut = new int[10];
        for(int i=0;i<3;i++) {
            number*= Integer.parseInt(br.readLine());
        }
        while (number >0) {
            conut[number%10]++;
            number/=10;
        }
        for(int i=0;i<conut.length;i++) {
            System.out.println(conut[i]);
        }
    }
}