import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");

        int result = Integer.parseInt(data[0]) == 1 ? 1 : Integer.parseInt(data[0]) == 8 ? -1 : 0;

        if(result != 0) {
            for(int i=0;i <data.length-1;i++) {
                if(Integer.parseInt(data[i+1]) - Integer.parseInt(data[i]) != result) {
                    result = 0;
                    break;
                }
            }
        }
        printResult(result);
    }

    public static void printResult(int result) {
        switch (result) {
            case 0 : System.out.println("mixed"); break;
            case 1 : System.out.println("ascending"); break;
            case -1 : System.out.println("descending"); break;
         }
    }
}
