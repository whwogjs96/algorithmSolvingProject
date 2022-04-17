import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        //특정 id가 신고당한 횟수
        int[] reportCount = new int[id_list.length];
        //동일한 id를 여러번 신고해도 1번으로 파악되기 때문에
        //중복을 허용하지 않는 set 사용
        HashSet<String>[] reportId = new HashSet[id_list.length];
        for(int i= 0; i< id_list.length;i++) reportId[i] = new HashSet<String>();
        for (String s : report) {
            String[] data = splitData(s);
            //data[0]은 신고한 id, data[1]은 신고당한 id
            int position = findCount(id_list, data[0]);
            reportId[position].add(data[1]);//특정 id의 신고한 id를 저장
        }

        //set 내부에 저장된 각 아이디가 다른 아이디를 신고한 횟수를 파악
        for (HashSet<String> reportsId : reportId) {
            for (String id : reportsId) {
                int position = findCount(id_list, id); //신고당한 id의 위치 찾기
                reportCount[position]++;//신고 count 더하기
            }
        }
        for(int i=0;i<reportCount.length;i++) {
            //i번째 id가 k번 이상 신고당한 경우
            if(reportCount[i] >=k) {
                for(int j=0;j<reportId.length;j++) {
                    //k번 이상 신고당한 id를 신고한 id인 경우 전송횟수 더하기
                    if(reportId[j].contains(id_list[i])) answer[j]++;
                }
            }
        }
        return answer;
    }

    public String[] splitData(String report) {
        return report.split(" ");
    }

    public int findCount(String[] id_list, String character) {
        for(int i=0; i<id_list.length;i++) {
            if(id_list[i].equals(character)) return i;
        }
        return -1;
    }
}