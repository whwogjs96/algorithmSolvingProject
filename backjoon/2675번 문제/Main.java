import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<String> data = new ArrayList<>();
        for(int i =0; i< testCase;i++) {
            String[] line = br.readLine().split(" ");
            StringBuilder result = new StringBuilder();
            int repeat = Integer.parseInt(line[0]);
            for(int j=0;j<line[1].length();j++) {
                for(int x=0;x<repeat;x++) {
                    result.append(line[1].charAt(j));
                }
            }
            data.add(result.toString());
        }
        for (int i=0;i<data.size();i++) {
            System.out.println(data.get(i));
        }
    }
}