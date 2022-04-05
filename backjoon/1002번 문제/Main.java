import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        int [] location = new int[6];
        int testCase; //테스트 케이스 변수
        Vector<String> value = new Vector<>();
        Scanner sc = new Scanner(System.in);
        testCase = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<testCase;i++) value.add(sc.nextLine());
        for(int a=0;a<value.size();a++)
        {
            StringTokenizer st = new StringTokenizer(value.get(a));
            for(int b=0;st.hasMoreTokens();b++)
            {
                location[b] = Integer.parseInt(st.nextToken());
            }
            System.out.println(locationNumber(location[0],location[1],location[2],location[3],location[4],location[5]));
        }

    }

    static int locationNumber(int x1, int y1, int r1, int x2, int y2, int r2)
    {
        double distance = getDistance(x1,y1,x2,y2);

        //두 점 사이의 거리가 두 반지름을 합한 것 보다 클 경우 두 원은 만나지 않는다.
        if(distance>r1+r2) return 0;
        //두 점 사이의 거리가 두 원의 반지름과 같은 경우 한 점에서 만난다.
        else if(distance==r1+r2) return 1;
        else if(distance==0) {
            //두 점 사이의 거리가 0일 때 반지름이 같으면 동일한 원이라 무수히 많은 점에서 만난다.
            if(r1==r2) return -1;
            //두 점 사이의 거리가 0일 때 반지름이 다르면 한 원이 다른 원 안에 존재한다.
            else return 0;
        }
        //distance < r1+r2 이면서 0이 아닐 때
        else
        {
            int largeR = Math.max(r1, r2);
            int smallR = Math.min(r1, r2);
            //큰 반지름보다 거리가 더 큰 경우
            if(distance>=largeR) return 2;
            //큰 반지름보다 거리가 작은 경우 한 원 안에 다른 원이 존재
            else
            {
                //내접하는 경우
                if(distance==largeR-smallR) return 1;
                //한 원이 다른 원 안에 존재하는 경우
                else if (distance<(largeR-smallR)) return 0;
                //distance > (largeR-smallR)인 경우
                //한 원의 중심이 다른 원 안에 있지만 내접하지 않으면서 작은 원이
                //큰 원의 중심을 포함하는 경우에 두 점에서 만난다.
                else return 2;
            }
        }
    }

    //거리 계산 메소드
    static Double getDistance(int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(Math.pow(Math.abs(x2-x1),2)+Math.pow(Math.abs(y2-y1),2));
    }
}
