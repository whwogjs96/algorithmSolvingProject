import java.util.*;

public class StripComments {

    public static String stripComments(String text, String[] commentSymbols) {
        //라인 단위로 자르기
        String[] lines = text.split("\n");
        ArrayList<String> result = new ArrayList();
        for(int i =0;i<lines.length;i++) {
            String line = lines[i];
            //각 심볼들의 위치를 파악해서 거기까지 라인 자르기
            for(int j = 0; j<commentSymbols.length;j++) {
                int index = lines[i].indexOf(commentSymbols[j]);
                if(index != -1) {
                    line = lastWhitespaceDelete(line.substring(0, index));
                } else line = lastWhitespaceDelete(line);
            }
            result.add(line);
        }
        StringBuilder resultString = new StringBuilder();
        for(int i=0;i<result.size();i++) {
            //마지막 string일 땐 엔터를 넣지 않음
            if(i == result.size()-1) {
                resultString.append(result.get(i));
                break;
            }
            resultString.append(result.get(i)).append("\n");
        }
        return resultString.toString();
    }

    //마지막에 있는 엔터 없애기
    public static String lastWhitespaceDelete(String data) {
        return data.replaceAll("\\s+$", "");
    }
}