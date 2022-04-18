import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        int computerCount = 10;//컴퓨터는 10대로 고정
        int[][] data = new int[testCase][2];//처리할 데이터
        for(int i=0; i<testCase; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<testCase; i++) {
            ArrayList<Integer> repeatNumber = new ArrayList();
            int remainder;
            int modular = 2;
            //컴퓨터는 10대라서 앞자리수에 따라 마지막에 처리하는 컴퓨터가 정해짐
            //제곱수는 특정 1의 자리 숫자를 계속 반복
            repeatNumber.add(data[i][0]%computerCount);
            while (true) {
                remainder = (int) (Math.pow(data[i][0], modular)%computerCount);
                //제곱하지 않은 첫 번째 숫자와 1의 자리가 같은 제곱수가 나올때까지 반복
                if(repeatNumber.get(0) != remainder) {
                    repeatNumber.add(remainder);
                    modular++;
                }
                else break;
            }
            if(repeatNumber.size() == 1) printResult(repeatNumber.get(0));
            else {
                int bRemainder = data[i][1]%repeatNumber.size(); //제곱수의 1의 자리 파악
                int result = bRemainder!=0 ? repeatNumber.get(bRemainder -1) : repeatNumber.get(repeatNumber.size()-1);
                printResult(result);
            }
        }
    }

    public static void printResult(int result) {
        if(result != 0) System.out.println(result);
        else System.out.println("10");
    }
}