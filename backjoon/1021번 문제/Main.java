import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static LinkedList<Integer> queue = new LinkedList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        String[] popNumbers = br.readLine().split(" ");
        int queueSize = Integer.parseInt(line[0]);
        int extractionCount = Integer.parseInt(line[1]);
        for(int i = 1 ; i<= queueSize; i++) {
            queue.add(i);
        }
        for(int i = 0; i<extractionCount;i++) {
            int index = queue.indexOf(Integer.parseInt(popNumbers[i]));
            if(queue.size() - index > index) {//뒤로 미는게 빠를 때
                for(int j = 0; j< index;j++) moveForward();
            } else { //앞으로 미는게 빠를 때
                for(int j = 0; j< queue.size() - index;j++) moveBack();
            }
            pop();
        }
        System.out.println(answer);
    }

    //첫 번째 데이터를 맨 앞으로 이동
    public static void moveBack() {
        int moveData = queue.get(queue.size() - 1);
        queue.add(0, moveData);
        queue.remove(queue.size() - 1);
        answer++; //이동 횟수 더하기
    }

    //첫 번째 데이터 뽑기
    public static void pop() { queue.remove(0); }

    //첫 번째 data를 맨 뒤로 이동
    public static void moveForward() {
        int moveData = queue.get(0);
        queue.add(moveData);
        queue.remove(0);
        answer++; //이동 횟수 더하기
    }
}