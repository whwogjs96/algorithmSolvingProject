import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int locationNumber = Integer.parseInt(br.readLine());
        int number = 1;
        int cycle;
        if(locationNumber == 1) System.out.println(1);
        else {
            for(cycle = 0; locationNumber - number >0;number += 6*cycle, cycle++){}
            System.out.println(cycle);
        }
    }
}
