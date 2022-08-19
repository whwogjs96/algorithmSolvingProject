import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        ArrayList<CalcData> dataList = new ArrayList<CalcData>();
        
        for(int i=1;i<N+1;i++) {
            int success = 0;
            int failure = 0;
            for(int stage : stages) {
                if(stage == i) failure++; //같으면 그 곳에 머무는 사람
                if(stage > i) success++; //스테이지가 i보다 크면 i 스테이지는 이미 통과한 사람
            }
            if(failure == 0) dataList.add(new CalcData(i, 0));
            else dataList.add(new CalcData(i, (double)failure/(failure+success)));
        }
        Collections.sort(dataList);
        for(int i=0;i<dataList.size();i++) {
            answer[i] = dataList.get(i).num;
        }
        return answer;
    }
}

//Collections.sort를 사용하기 위한 Comparable class
class CalcData implements Comparable<CalcData> {
    int num = 0;
    double failureRate = 0.0;
    
    public CalcData(int num) { this.num = num;}
    
    public CalcData(int num, double failureRate) {
        this.num = num;
        this.failureRate = failureRate;
    }
    
      @Override
    public int compareTo(CalcData o) {
        if (this.failureRate == o.failureRate) {
        return this.num < o.num ? -1 : 1;
        } else {
            return this.failureRate > o.failureRate ? -1 : 1;
        }
    }
}