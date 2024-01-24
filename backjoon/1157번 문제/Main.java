import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine().toUpperCase(Locale.ROOT);
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for(int i=0;i<data.length();i++) {
            int number = 1;
            if(map.containsKey(data.charAt(i))) { number = map.get(data.charAt(i))+1; }
            max = Math.max(number, max);
            map.put(data.charAt(i), number);
        }
        char result = '?';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (max == value) {
                if(result != '?') {
                    result = '?';
                    break;
                }
                result = key;
            }
        }
        System.out.println(result);
    }
}