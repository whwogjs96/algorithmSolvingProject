import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        //sorting한 time 테이블에서 맨 뒷 사람만 모든 사람을 했을 때가 제일 느려
        //시작 max 값으로 지정
        long max = n*(long)times[times.length-1];
        long answer = max;
        long min = 1;
        //max는 0일 수 없어 무조건 1번 이상 동작
        while(min <= max) {
            //이 문제는 제일 느리게 처리하는 사람이 처리하는 수가 가장 적어야 하는게 목표
            //이분 탐색을 통해 중간 사람이 한 명 처리하는데 그보다 빠른 심사관이 처리한 수가 n인 경우
            //그 중간 사람이 1명 처리하는 시간만 사용하면 모두 처리가 가능하다고 판단
            //만약 중간 사람이 1명을 처리했음에도 다 처리하지 못한 경우에는 다시 그 중간 사람을 시작으로
            //다음 중간 사람을 선택해 그 사람이 1명 처리하는 동안 다 처리가 가능한 지 판단
            //그 중간 사람이 다 처리했을 때 시간이 남는다면 그보다 더 앞의 심사관까지만 가도록 수정
            //이를 반복하면 최적의 해가 도출
            long count = 0;
            long middle = (max + min)/2;
            for(int time : times) {
                //middle 시간이 흘렀을 때 처리할 수 있는 사람의 수를 count에 더함
                count += middle/time;
            }
            //middle 시간 내에 모든 사람을 처리하고 남은 경우
            if(count >= n){
                //최대값을 middle의 절반으로 변경
                max = middle - 1;
                answer = Math.min(answer, middle);
            } 
            //아직 처리해야 할 사람이 더 남은 경우
            else min = middle + 1;
        }
        return answer;
    }
}