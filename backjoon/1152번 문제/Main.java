import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        String[] list = data.split(" ");
        int result = list.length;
        if(result > 0) {
            //처음과 끝이 공백인지만 파악
            if(list[0].isBlank()) result--;
            if(list[list.length-1].isBlank()) result--;
        }

        System.out.println(result);
    }
}
