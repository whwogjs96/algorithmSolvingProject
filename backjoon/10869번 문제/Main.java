import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        input[0] = Integer.parseInt(st.nextToken());
        input[1] = Integer.parseInt(st.nextToken());
        System.out.println(input[0]+input[1]);
        System.out.println(input[0]-input[1]);
        System.out.println(input[0]*input[1]);
        System.out.println(input[0]/input[1]);
        System.out.println(input[0]%input[1]);
    }
}