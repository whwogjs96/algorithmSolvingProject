import java.io.*;
import java.util.HashSet;

public class Main {
    //W는 false로, B는 true로 정의
    static boolean white = false;
    static boolean black = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int min = 64;

        boolean[][] chess = new boolean[N][M];
        //빠르게 연산하도록 boolean 타입으로 변환
        //boolean type 체스판 생성
        for(int i = 0 ; i< N; i++) {
            String line = br.readLine();
            for(int j = 0; j< M ; j++) {
                if(line.charAt(j) == 'W') chess[i][j]= white;
                else chess[i][j] = black;
            }
        }

        //각 점을 돌면서 min count 파악
        for(int i = 0; i< N-7;i++) {
            for(int j = 0; j< M-7; j++) {
                int count = getChangeCount(chess, i , j);
                //하나의 체스판이 white로 시작하는 경우와 black으로 시작하는 경우가 존재
                //white 시작한 제대로 된 체스판을 전부 반대로 칠하면 black으로 시작한 체스판이 됨.
                //8x8 체스판을 모두 반대로 칠하는데 필요한 횟수는 64회
                min = Math.min(min, Math.min(count, 64 - count));
            }
        }

        System.out.println(min);
    }

    //brute force 방식으로 체스판 색상 변경 횟수를 찾는 메소드
    public static int getChangeCount(boolean[][] chess, int n, int m) {
        int count = 0;
        //white 시작을 가정
        boolean color = white;
        for(int i = n; i< n + 8; i++) {
            for(int j = m; j< m + 8 ; j++) {
                if(chess[i][j] != color) count++;
                color = !color;
            }
            color = !color;
        }
        return count;
    }
}