import java.io.*;
import java.util.StringTokenizer;

public class Main {

    //강의 서쪽과 동쪽의 사이트의 최대값은 30
    public static final int MAX = 30;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //이 문제는 다리끼리 겹칠 수 없고, 동쪽과 서쪽이 하나씩 연결되어야 하기 때문에
        //동쪽 게이트의 숫자 중 순서에 상관 없이 서쪽 게이트의 개수만큼 뽑는 경우의 수
        int combination[][] = new int[MAX][MAX];

        //조합의 경우의 수 구하기
        for(int n=0;n<MAX;n++) {
            for(int m=0;m<MAX;m++) {
                if(n==m || n==0 || m==0) combination[n][m] = 1;
                else {
                    //nCr = (n-1)C(r-1) + (n-1)Cr 공식
                    combination[n][m] = combination[n-1][m-1] + combination[n][m-1];
                }
            }
        }
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<testCase;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int west = Integer.parseInt(st.nextToken());
            int east = Integer.parseInt(st.nextToken());
            sb.append(combination[west][east]).append("\n");
        }
        System.out.println(sb);
    }
}