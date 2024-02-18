import java.io.*;
import java.util.*;

public class Main {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken()) - 45;
        if(minute >= 60) {
            minute -= 60;
            hour++;
        } else if(minute < 0 ) {
            minute+=60;
            hour--;
        }
        if(hour>=24) hour -= 24;
        else if(hour < 0) hour += 24;
        System.out.println(hour + " " + minute);
    }
}