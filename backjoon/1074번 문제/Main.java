import java.io.*;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int r = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);
        int size = (int) Math.pow(2, N);
        getResult(size, r, c);
        System.out.println(result);
    }

    static public void getResult(int size, int r, int c) {
        if(size == 1) { return; }
        //각 4분면을 하나씩 지날때마다 2^n * 2^n / 4의 값이 증가되는 것을 알 수 있음
        int count = (size * size) /4;
        if(r < size/2 && c < size/2) {
            //1사분면의 경우 1사분면이 가진 숫자에서 시작하기 때문에 숫자의 변경이 일어나지 않음
            getResult(size/2, r, c);
        } else if(r < size/2 && c >= size/2) {
            result += count;
            getResult(size/2, r, c - size/2);
        } else if(r >= size/2 && c < size/2) {
            result += count * 2;
            getResult(size/2, r - size/2, c);
        } else {
            result += count * 3;
            getResult(size/2, r - size/2, c - size/2);
        }
    }
}
// map에 데이터를 저장하는 형태로 작성한 코드
// 이렇게 작성하는 경우에 시간 및 메모리 초과가 뜸
// 결국 각 사분면 중 하나만 이용하는 형태로 작성하는 것이 중요
//import java.io.*;
//public class Main {
//    static int[][] zMap;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] line = br.readLine().split(" ");
//        int N = Integer.parseInt(line[0]);
//        int r = Integer.parseInt(line[1]);
//        int c = Integer.parseInt(line[2]);
//        int size = (int) Math.pow(2, N);
//        zMap = new int[size][size];
//        mapCreate(N, 0, 0, 0);
//        System.out.println(zMap[r][c]);
//    }
//
//    static public void mapCreate(int N, int startNumber, int x, int y) {
//        if(N == 0) {
//            zMap[x][y] = startNumber;
//            return;
//        }
//        int size = (int) Math.pow(2, N - 1);
//        int referenceValue = size*size;
//        mapCreate(N-1, startNumber, x, y);
//        mapCreate(N-1, startNumber + referenceValue, x, y + size);
//        mapCreate(N-1, startNumber + referenceValue*2, x + size, y);
//        mapCreate(N-1, startNumber + referenceValue*3, x + size, y + size);
//    }
//}