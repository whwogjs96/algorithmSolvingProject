import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    //예제 1번 기준
    //B[P[0]] = A[0] = (index = 0, value = 2)
    //B[P[1]] = A[1] = (index = 1, value = 3)
    //B[P[2]] = A[2] = (index = 2, value = 1)
    //정렬 후
    //B[P[2]] = B[0] = A[2] = (index = 2, value = 1)
    //B[P[0]] = B[1] = A[0] = (index = 0, value = 2)
    //B[P[1]] = B[2] = A[1] = (index = 1, value = 3)
    //P[2] = 0, P[0] = 1, P[1] = 2
    //순서대로 출력
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        ArrayList<NonDescendingData> data = new ArrayList<>();
        for(int i = 0; i <line.length; i++) {
            data.add(new NonDescendingData(i, Integer.parseInt(line[i])));
        }
        Collections.sort(data);
        int[] result = new int[data.size()];
        //B[P[i]] = A[i]를 만족하기 위해 사용
        for(int i = 0 ;i<result.length;i++) {
            result[data.get(i).index] = i;
        }
        for(int number : result) {
            System.out.print(number+" ");
        }
    }
}

//index와 값 관리를 편하게 하기 위한 data class
class NonDescendingData implements Comparable<NonDescendingData>{
    int index;
    int value;

    NonDescendingData(int index, int value) {
        this.index = index;
        this.value = value;
    }

    //Collections.sort(data) 사용을 위한 코드
    @Override
    public int compareTo(NonDescendingData o) {
        if(o.value == value) {
            return index - o.index;
        } else return value -o.value;
    }

}