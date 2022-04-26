import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //스코빌은 int 형이고 스코빌 지수는 가장 작은 수부터 계산하기 떄문에
        //우선순위 queue를 통해 작은순으로 정렬하면 계산하기 편함
        for(int i =0;i<scoville.length;i++) {
            priorityQueue.offer(scoville[i]);
        }
        //2개 이상 섞어야 하므로 큐에 남은 재료가 2개 이상이어야 함
        while(priorityQueue.size() >= 2) {
            int lowestData = priorityQueue.poll();
            //현재 가장 스코빌 지수가 낮은 음식이 기준치보다 작다면 다음 음식과 섞어야 함
            if(lowestData < K) {
                int lowData = priorityQueue.poll();
                //섞은 후 큐에 삽입
                priorityQueue.offer((lowestData + lowData*2));
                answer++; //섞은 횟수 증가
            } else return answer; //큐를 모두 돌기 전에 조건을 만족할 경우 정답 반환
        }
        //큐를 모두 돌아 음식이 1개만 남았을 때 남은 음식의 스코빌 지수가 k보다 큰 경우
        //섞은 횟수 출력, 아닌 경우 다 섞어도 기준치를 초과할 수 없으므로 -1 반환
        if(priorityQueue.size() == 1 && priorityQueue.poll() >= K) return answer;
        return -1;
    }
}