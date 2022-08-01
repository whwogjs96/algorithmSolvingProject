import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap map = new HashMap<Integer, Integer>();
        for(int i =0; i< nums.length; i++) {
            if(!map.containsKey(nums[i])) map.put(nums[i], nums[i]);
        }
        if(map.size() < nums.length/2) answer = map.size();
        else answer = nums.length/2;
        return answer;
    }
}