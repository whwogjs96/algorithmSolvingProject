import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] data = st.nextToken().toCharArray();
        int result = 0;
        for(int i = 0;i<data.length;i++) {
            result += data[i] - '0';
        }
        System.out.println(result);
    }
}