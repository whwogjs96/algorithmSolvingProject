import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Kg = Integer.parseInt(br.readLine());
        int count = 0;
        while(Kg >2) {
            if(Kg%5%3 == 0) {
                count += Kg/5+Kg%5/3;
                break;
            } else {
                Kg -= 3;
                count++;
            }
        }
        if(Kg < 3) System.out.println(-1);
        else System.out.println(count);
    }
}