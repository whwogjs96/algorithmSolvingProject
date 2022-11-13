import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testLocationCount = Integer.parseInt(br.readLine());
        int [] numberOfStudent = new int[testLocationCount];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < testLocationCount;i++) {
            numberOfStudent[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int generalManager = Integer.parseInt(st2.nextToken());
        int manager = Integer.parseInt(st2.nextToken());

        long numberOfManager = 0;
        for(int i = 0; i< testLocationCount ; i++) {
            int result = numberOfStudent[i] - generalManager;
            if(result <= 0) numberOfManager++;
            else if(result%manager == 0 ) numberOfManager += (result/manager)+1;
            else numberOfManager += (result/manager)+2;
        }

        System.out.println(numberOfManager);
    }
}