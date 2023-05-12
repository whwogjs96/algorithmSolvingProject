import java.util.*;

class Solution {
    ArrayList<Integer>[] list;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        list = new ArrayList[n+1];
        for(int i=0;i<list.length;i++) list[i] = new ArrayList<Integer>();
        for(int i=0;i<wires.length;i++) {
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }
        for(int i=0;i<wires.length;i++) {
            answer = Math.min(answer, Math.abs(getNodeCount(wires[i][0], wires[i][1]) - getNodeCount(wires[i][1], wires[i][0])));
        }
        return answer;
    }
    
    public int getNodeCount(int target, int exceptNumber) {
        int result = 1;
        ArrayList<Integer> targetList = list[target];
        for(int i=0;i<targetList.size();i++) {
            if(targetList.get(i) != exceptNumber) {
                result+=getNodeCount(targetList.get(i), target);
            }
        }
        return result;
    }
}