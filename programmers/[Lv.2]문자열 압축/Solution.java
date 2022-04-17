class Solution {
    public int solution(String s) {
        int min = s.length();
        if(s.length() ==1 ) return 1;
        //자르는 단위가 문자열의 절반을 넘기면 자를 수 없음
        for(int i=1; i<=s.length()/2;i++) {
            min = Math.min(min,compress(i, s).length());
        }
        return min;
    }

    //파라미터로 받은 wordSlice 단위로 자른 문자열 반환
    String compress(int wordSlice, String s) {
        int count = 1;
        String prevString = "";
        //결과값을 String에 저장하면 java 특성상 조금 느려짐
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length()+wordSlice;i+=wordSlice) {
            String nowString = "";
            if(i+wordSlice <= s.length()) {
                nowString = s.substring(i, i+wordSlice);
                //현재 보는 문자열이 처음인 경우
                if(prevString.equals("")) {
                    prevString = nowString;
                    continue;
                }
            //마지막에 글자수가 8개인 경우 3으로 나누면 2개가 남는 경우처럼
            //개수가 알맞게 떨어지지 않는 경우 무시당하는 것을 방지해주기 위해 작성
            } else if(i<s.length()) {
                nowString = s.substring(i);
            }

            //같으면 count만 세고 다음으로 넘어갑니다.
            //마지막 문자열이 prevString과 다른 경우,
            //nowString이 "" 값이 되어 아래로 들어가게 됩니다.
            if(prevString.equals(nowString)) count++;
            else {
                //이전까지 판단했던 string이 몇 번 나왔는지를 기준으로 작성합니다.
                if(count>=2) {
                    result.append(count).append(prevString);
                    count = 1;
                }
                else result.append(prevString);
            }
            prevString = nowString;
        }
        return result.toString();
    }
}