import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String data[] = new String[testCase];
        for(int i=0; i<testCase;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());
            int layer = (number%H == 0)? H : number%H;
            int room = (number%H == 0) ?number/H : number/H + 1;
            if(room < 10) data[i] = layer + "0" +room;
            else data[i] = layer+""+room;
        }
        for(String result : data) System.out.println(result);
    }
}