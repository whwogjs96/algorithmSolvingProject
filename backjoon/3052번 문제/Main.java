import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<10;i++) {
            int data = Integer.parseInt(br.readLine());
            set.add(data%42);
        }
        System.out.println(set.size());

    }
}