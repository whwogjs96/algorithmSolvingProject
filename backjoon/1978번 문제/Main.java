import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        ArrayList list = new ArrayList<Integer>();//입력받은 숫자 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<list.size();i++) {
            if(searchPrimeNumber((Integer) list.get(i))) result++;
        }
        System.out.println(result);
    }

    public static boolean searchPrimeNumber(int target){

        //소수는 제곱근까지만 계산하면 됨
        for(int i=2;i<=Math.sqrt(target);i++) {
            if(target%i ==0) return false;
        }
        return target != 1;
    }
}