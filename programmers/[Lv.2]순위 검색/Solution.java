import java.util.*;

class Solution {
    HashMap<String, ArrayList<Integer>> dataList = new HashMap();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        //info 데이터 넣는 구간
        //조건을 key값으로 변경해 맵에 삽입
        for(int i=0;i<info.length;i++) {
            insert("",0,info[i].split(" "));
        }        
        
        Iterator<String> it= dataList.keySet().iterator();
        while(it.hasNext()) {
            Collections.sort(dataList.get(it.next()));
        }
        for(int i =0;i<query.length;i++) {
            
            //주문된 query를 key로 변경하는 작업
            query[i] = query[i].replaceAll(" and","");
            String[] queryData = query[i].split(" ");
            String key = queryData[0]+queryData[1]+queryData[2]+queryData[3];
            if(dataList.get(key)== null) {
                answer[i] = 0;
                continue;
            }
            ArrayList<Integer> list = dataList.get(key);
            int start =0;
            int end = list.size()-1;
            while(start<=end) {
                int mid = (start + end)/2;
                if(list.get(mid) < Integer.parseInt(queryData[4])) start = mid+1;
                else end = mid-1;
            }
            answer[i] = list.size() - start;
        }
        return answer;
    }
    
    public void insert(String key, int depth, String[] data) {
        //숫자 외에 모든 데이터가 키로 저장된 경우
        if(depth == 4) {
            ArrayList<Integer> temp;
            //데이터 내에 특정 조건을 key로 두는 경우 점수를 넘긴 사람의 수만 구하면 되기 때문에
            //리스트에는 점수만 저장해두고 사용할 때 조건 확인
            if(dataList.get(key) != null) temp = dataList.get(key);
            else temp = new ArrayList<Integer>();
            temp.add(Integer.parseInt(data[4]));
            dataList.put(key, temp);
            return;
        }
        //키는 조건을 고려하지 않는 경우(-)와
        //고려하는 경우 둘 다를 생각해서 해쉬맵에 삽입
        insert(key+"-",depth+1,data);
        insert(key+data[depth],depth+1,data);
    }
}