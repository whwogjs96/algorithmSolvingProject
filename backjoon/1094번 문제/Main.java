import java.io.*;

public class Main {

    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = cutAStick(0, Integer.parseInt(br.readLine()), 6);
        System.out.println(result);
    }

    public static int cutAStick(int count, int x, int startSquare) {
        int result = count;
        for(int i = startSquare; i>= 0 ; i--) {
            int xStick = (int) Math.pow(2, i);
            if(xStick <= x) {
                result = cutAStick(count + 1, x - xStick, i);
                break;
            }
        }
        return result;
    }
}