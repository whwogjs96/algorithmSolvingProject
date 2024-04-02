import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int chart[][] = new int[15][14];
        for(int i = 0;i<14;i++){
            chart[0][i] =i+1;
            chart[i][0] = 1;
        }
        chart[14][0]= 1;
        for(int x = 1; x<15;x++) {
            for(int y = 1;y<14;y++){
                chart[x][y] = chart[x][y-1] + chart[x-1][y];
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<testCase;i++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());
            sb.append(chart[floor][room-1]).append("\n");
        }
        System.out.println(sb);
    }
}