import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList list = new ArrayList<Integer>();
        while (st.hasMoreTokens()) {
            int data = Integer.parseInt(st.nextToken());
            list.add(data);
        }
        Collections.sort(list);
        System.out.println(list.get(0) + " " + list.get(list.size()-1));
    }
}