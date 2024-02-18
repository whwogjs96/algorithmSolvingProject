import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< testCase;i++) {
            int number = 0;
            int accumulate = 0;
            char[] data = br.readLine().toCharArray();
            for(int j=0;j<data.length;j++) {
                if(data[j] == 'O') {
                    number+=(++accumulate);
                } else accumulate = 0;
            }
            result.add(number);
        }
        for(int i=0;i<result.size();i++) {
            System.out.println(result.get(i));
        }

    }

}