import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] data = new int[testCase][2];
        for(int i =0 ;i<testCase;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int x = 0; x< testCase ; x++) {
            bw.write("" + (data[x][0] + data[x][1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}