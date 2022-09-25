import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<N ; i++) {
            result.append("*".repeat(N - i));
            result.append("\n");
        }
        System.out.println(result);
    }
    
}