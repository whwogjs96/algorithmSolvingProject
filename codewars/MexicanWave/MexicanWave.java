import java.util.*;

public class MexicanWave {

    public static String[] wave(String str) {
        char[] data = str.toCharArray();
        ArrayList<String> result = new ArrayList();
        for(int i =0;i<data.length;i++) {
            if(data[i] != ' ') {
                data[i] = Character.toUpperCase(data[i]);
                result.add(new String(data));
                data[i] = Character.toLowerCase(data[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }

}