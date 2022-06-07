import java.util.ArrayList;

class Solution {
    public Integer[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList();
        int[] result = new int[progresses.length]; //각 잡이 완료되는 날짜를 저장

        //각 job이 완료되는 날짜를 계산
        for(int i=0;i<result.length;i++) {
            int count=1;
            while(progresses[i]+speeds[i]*count<100) count++;
            result[i] = count;
        }
        for(int i=0;i<result.length;i++) {
            int publishingCount = 1;
            //이미 배포된 job
            if(result[i]==0) {
                continue;
            } else {
                //현재 배포될 가장 앞에 있는 job보다 다른 job의 날짜보다 긴 경우
                //그 날짜의 job은 배포되는 것으로 간주
                for(int j=i+1;j<result.length;j++) {
                    if(result[j] != 0 && result[i]>=result[j]) {
                        publishingCount++;
                        result[j]=0;
                    } else {
                        break;
                    }
                }
                answer.add(publishingCount);
            }
        }

        return answer.toArray(new Integer[answer.size()]);
    }
}