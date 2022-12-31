import java.util.*;

class Solution {
    public Integer[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> completeList = new ArrayList();
        ArrayList<Integer> answerList = new ArrayList();
        for(int i=0;i<numbers.length;i++) {
            if(!completeList.contains(numbers[i])) {
                for(int j=i+1;j<numbers.length;j++) {
                    int addedNumber = numbers[i]+numbers[j];
                    if(!answerList.contains(addedNumber)) answerList.add(addedNumber);
                }
            } else continue;
            
            completeList.add(numbers[i]);
        }
        Collections.sort(answerList);
        return answerList.toArray(new Integer[answerList.size()]);
    }
}