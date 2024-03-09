import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int examCount = Integer.parseInt(br.readLine());
        String scoreData = br.readLine();
        StringTokenizer st = new StringTokenizer(scoreData);
        int totalScore = 0;
        int max = 0;
        while(st.hasMoreTokens()) {
            int score = Integer.parseInt(st.nextToken());
            totalScore+=score;
            max = Math.max(max, score);
        }
        double average = (double)totalScore/(double)max*100.0/(double)examCount;
        System.out.println(average);
    }
}