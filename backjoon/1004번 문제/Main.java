import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] location = new int[4];
        int planetCount = 0;
        int count;
        sc.nextLine();
        //테스트 케이스만큼 반복
        for(int i=0; i<testCase; i++){
            String locationValue = sc.nextLine();
            StringTokenizer st = new StringTokenizer(locationValue);
            //출발, 도착지 저장
            for(int a = 0;st.hasMoreTokens();a++){
                location[a] = Integer.parseInt(st.nextToken());
            }
            count = 0;
            //행성 개수 저장
            planetCount = Integer.parseInt(sc.nextLine());
            int[][] planetData = new int[planetCount][3];
            //행성 위치 저장
            for(int b = 0; b<planetCount; b++){
                String planetDataString = sc.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(planetDataString);
                for(int x = 0; tokenizer.hasMoreTokens();x++){
                    planetData[b][x] = Integer.parseInt(tokenizer.nextToken());
                }
            }
            for(int computeCount = 0; computeCount < planetCount; computeCount++){
                if(!getCount(location[0], location[1], planetData[computeCount][0], planetData[computeCount][1], planetData[computeCount][2])){
                    if(getCount(location[2], location[3], planetData[computeCount][0], planetData[computeCount][1], planetData[computeCount][2])){
                        count++;
                    }
                } else if(!getCount(location[2], location[3], planetData[computeCount][0], planetData[computeCount][1], planetData[computeCount][2])){
                    count++;
                }
            }
            System.out.println(count);
        }

        sc.close();
    }

    static Boolean getCount(int startX, int startY, int planetX, int planetY, int round){
        return getDistance(startX, startY, planetX, planetY) > round;
    }

    static Double getDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
    }
}
