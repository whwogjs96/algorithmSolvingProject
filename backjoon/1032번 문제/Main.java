import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stringCount = Integer.parseInt(br.readLine());
        String[] strings = new String[stringCount];
        //라인 문장 저장
        for(int i =0; i<stringCount;i++) {
            strings[i] = br.readLine();
        }
        System.out.println(getOverlapString(strings));
    }

    //각 문장의 위치가 모두 동일한 경우에 그 위치는 true로 변경
    //true인 경우 다 동일한 것이므로 첫 번째 위치의 문자 저장
    public static String getOverlapString(String[] strings) {
        StringBuilder result = new StringBuilder();
        boolean[] isDifferent = new boolean[strings[0].length()];
        for(int i =0;i < strings[0].length();i++) {
            for(int j= 1;j<strings.length;j++) {
                if(strings[j].charAt(i) != strings[0].charAt(i)) {
                    isDifferent[i] = true;
                    break;
                }
            }
        }
        for(int i=0;i<isDifferent.length;i++) {
            if(isDifferent[i]) result.append("?");
            else result.append(strings[0].charAt(i));
        }
        return result.toString();
    }
}
