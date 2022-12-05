import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int notLost = 0;
        Arrays.sort(reserve);
        for(int i =0; i<lost.length;i++) {
            for(int j =0; j<reserve.length;j++) {
                if(lost[i] == reserve[j]){
                    notLost++;
                    lost[i]= -1;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        for(int i =0; i<lost.length;i++) {
            for(int j =0; j<reserve.length;j++) {
                if(reserve[j] > lost[i] + 1) break;
                if(lost[i] -1 == reserve[j] || lost[i] +1 == reserve[j]){
                    notLost++;
                    reserve[j]=-1;
                    break;
                }
            }
        }
        answer = n-lost.length+notLost;
        return answer;
    }
}