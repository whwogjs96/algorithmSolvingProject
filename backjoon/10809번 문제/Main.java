import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] indexList = new int[26];
        Arrays.fill(indexList, -1);
        for(int i = 0 ;i<S.length();i++) {
            if(indexList[S.charAt(i) - 'a'] == -1) indexList[S.charAt(i) - 'a'] = i;
        }
        for(int index : indexList) {
            System.out.print(index+" ");
        }
    }
}