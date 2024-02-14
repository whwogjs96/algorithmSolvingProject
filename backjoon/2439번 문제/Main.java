import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=count ; i++) {
            for(int a = 0; a<count-i ;a++) {
                sb.append(" ");
            }
            for(int b = count-i; b<count ;b++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}