class Solution {
    //124나라는 1, 2, 4 세개의 숫자로 이루어졌기 때문에
    //3진수 표현법
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int quotient = n/3; //몫
        int remainder = n%3; //나머지
        if(remainder == 0) quotient -=1;
        if(n >3) {
            while(quotient !=0) {
                int remainderFromQuotient = quotient%3;
                //나머지가 0인 경우에만 4를 출력하도록 되어 있음
                if(remainderFromQuotient == 0){
                    sb.insert(0,"4");
                    quotient = (quotient/3)-1;
                } else {
                    sb.insert(0,quotient%3);
                    quotient /=3;
                }
            }
        }
        //남은 나머지 판별
        if(remainder == 0) sb.append("4");
        else sb.append(remainder);
        return sb.toString();
    }

}