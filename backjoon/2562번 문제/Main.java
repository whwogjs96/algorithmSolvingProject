import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i=0;i<9;i++) {
            int data = Integer.parseInt(br.readLine());
            if(data > max) {
                max = data;
                index = i+1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }
}