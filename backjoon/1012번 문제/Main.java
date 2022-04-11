import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ;i<testCase;i++) {
            int earthwormCount = 0; //지렁이 갯수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());// 가로 길이
            int y = Integer.parseInt(st.nextToken());// 세로 길이
            int k = Integer.parseInt(st.nextToken());// 배추가 심겨진 위치의 갯수
            int location[][] = new int[x][y];
            //배추가 심겨진 위치를 1로 변경
            for(int j = 0;j<k;j++) {
                String[] loc = br.readLine().split(" ");
                int tempX = Integer.parseInt(loc[0]);
                int tempY = Integer.parseInt(loc[1]);
                location[tempX][tempY] = 1;
            }
            for(int locX = 0; locX<x;locX++) {
                for (int locY = 0;locY<y;locY++) {
                    if(location[locX][locY] == 1) {
                        earthwormCount++;
                        location[locX][locY]=2; //이미 지렁이가 관리하는 곳은 2로 판단
                        earthwormFall(location,x,y,locX,locY);
                    }
                }
            }
            sb.append(earthwormCount).append("\n");
        }
        System.out.println(sb);
    }

    public static void earthwormFall(int [][]location, int x, int y, int locX, int locY) {
        //왼쪽으로 더 이동할 수 있고, 왼쪽에 배추가 있을 때
        if(locX != 0 && location[locX-1][locY] == 1){
            location[locX-1][locY]=2;
            earthwormFall(location,x,y,locX-1,locY);
        }
        //아래쪽으로 더 이동할 수 있고, 아래쪽에 배추가 있을 때
        if(locY != 0 && location[locX][locY-1] == 1){
            location[locX][locY-1]=2;
            earthwormFall(location,x,y,locX,locY-1);
        }
        //오른쪽으로 더 이동할 수 있고, 오른쪽에 배추가 있을 때
        if(locX+1 != x && location[locX+1][locY] == 1){
            location[locX+1][locY]=2;
            earthwormFall(location,x,y,locX+1,locY);
        }
        //위쪽으로 더 이동할 수 있고, 위쪽에 배추가 있을 때
        if(locY+1 != y && location[locX][locY+1] == 1){
            location[locX][locY+1]=2;
            earthwormFall(location,x,y,locX,locY+1);
        }
    }
}