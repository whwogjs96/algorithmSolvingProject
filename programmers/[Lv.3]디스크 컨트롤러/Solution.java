import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;
        PriorityQueue<Disc> priorityQueue = new PriorityQueue<>();
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override 
            public int compare(int[] o1, int[] o2) { 
                if(o1[0] == o2[0]) { 
                    return o1[1] - o2[1]; 
                } else { 
                    return o1[0] - o2[0]; 
                } 
            }
        });
        int index = 0;
        while(true) {
            if(index >= jobs.length) {
                Disc jobDisc = priorityQueue.poll();
                currentTime+=jobDisc.jobTime;
                answer+=currentTime - jobDisc.requestTime;
                if(priorityQueue.isEmpty()) break;
            } else {
                int[] job = jobs[index];
                if(priorityQueue.isEmpty()) {
                    //if(currentTime < job[0]) currentTime = job[0];
                    priorityQueue.offer(new Disc(job[0], job[1]));
                    index++;
                } else {
                    if(currentTime >= job[0]) {
                        priorityQueue.offer(new Disc(job[0], job[1]));
                        index++;
                    } else {
                        Disc jobDisc = priorityQueue.poll();
                        currentTime+=jobDisc.jobTime;
                        answer+=currentTime - jobDisc.requestTime;
                    }
                }
            }
        }
        return answer/jobs.length;
    }
}

class Disc implements Comparable<Disc> {
    int requestTime;
    int jobTime;
    public Disc(int requestTime, int jobTime) {
        this.requestTime = requestTime;
        this.jobTime = jobTime;
    }
    
    @Override
    public int compareTo(Disc target) {
        return this.jobTime <= target.jobTime ? -1 : 1;
    }
}