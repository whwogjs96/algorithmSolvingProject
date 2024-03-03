import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        count = Integer.parseInt(st.nextToken());
        max = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i< count ; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            if(temp < max) sb.append(temp+ " ");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }
}