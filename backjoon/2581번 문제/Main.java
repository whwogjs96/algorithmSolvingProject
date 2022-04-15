import java.io.*;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = N;
        //1은 아래 메소드에서 무조건 소수로 판별하기 때문에
        //1일때는 2부터 시작
        if(M == 1) M = 2;
        for(int i=M;i<=N;i++) {
            if(searchPrimeNumber(i)) {
                sum+=i;
                if(i < min) min = i;
            }
        }
        if(sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        } else {
            System.out.println(-1);
        }

    }

    //소수 판별 메소드
    public static boolean searchPrimeNumber(int number) {
        for(int j= 2;j<=Math.sqrt(number);j++) {
            if(number%j == 0) return false;
        }
        return true;
    }
}