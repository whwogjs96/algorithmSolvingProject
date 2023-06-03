class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        char[] array = s.toCharArray();
        boolean isAnswered = true;
        for(int left =0; left<s.length()-2;left++) {
            if(s.length() - left < answer) break;
            for(int right = s.length() ; right > left ;right--) {
                isAnswered = true;
                if(right - left < answer) break;
                for(int i =left; i< (left+right)/2;i++) {
                    if(array[i] != array[(left+right) -i -1]){
                        isAnswered = false;
                        break;
                    }
                }
                if(isAnswered) answer = Math.max(answer, right - left);
            }
            
        }
        return answer;
    }
}