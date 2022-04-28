import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer;
        //입장과 퇴장을 저장하기 위한 리스트
        ArrayList<RecordData> resultData = new ArrayList<RecordData>();
        //user의 아이디와 닉네임을 매치시킬 해시맵
        HashMap<String, String> userId = new HashMap<String, String>();
        for(String data : record) {
            String[] splitData = data.split(" ");
            //입장인 경우
            if(splitData[0].equals("Enter")){
                userId.put(splitData[1], splitData[2]);
                resultData.add(new RecordData(0, splitData[1]));
            }
            //퇴장인 경우
            else if(splitData[0].equals("Leave")) resultData.add(new RecordData(1, splitData[1]));
            else userId.put(splitData[1], splitData[2]); //아이디 변경의 경우
        }
        answer = new String[resultData.size()];
        for(int i=0;i<resultData.size();i++) {
            RecordData data = resultData.get(i);
            StringBuilder log = new StringBuilder(); //결과값을 출력할 log
            log.append(userId.get(data.id)).append("님이 ");
            if(data.command == 0) log.append("들어왔습니다.");
            else log.append("나갔습니다.");
            answer[i] = log.toString();
        }
        return answer;
    }
}

//데이터를 저장하기 위한 data class
//command가 0인 경우 입장, 1인 경우 퇴장
class RecordData {
    int command;
    String id;

    RecordData(int command, String id) {
        this.command = command;
        this.id = id;
    }
}