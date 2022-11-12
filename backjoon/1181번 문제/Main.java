import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> resultList = new ArrayList<>();
        for(int i = 0;i<N ; i++) {
            String data = br.readLine();
            int index = insertIndex(resultList, data);
            if(index != -1) resultList.add(index, data);
        }
        for (int i=0;i< resultList.size();i++) System.out.println(resultList.get(i));
    }

    public static int insertIndex(ArrayList<String> list, String data) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int middle = (end + start)/2;
            String middleData = list.get(middle);
            if(middleData.length() > data.length()) end = middle;
            else if(middleData.length() == data.length()) {
                int compare = middleData.compareTo(data);
                if(compare > 0) end = middle;
                else if (compare == 0) return - 1;
                else start = middle+1;
            }
            else start = middle+1;
        }
        return start;
    }
}