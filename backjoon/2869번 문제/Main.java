import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        if((V-A)%(A-B) != 0) {
            System.out.println((V-A)/(A-B)+2);
        } else {
            System.out.println((V-A)/(A-B)+1);
        }
    }
}