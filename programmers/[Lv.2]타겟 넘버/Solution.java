class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        //재귀함수 이용
        getReturn(numbers, target, 0, numbers[0]);
        getReturn(numbers, target, 0 , -numbers[0]);
        return answer;
    }

    public void getReturn(int[] numbers, int target, int position, int preResult) {
        //마지막 숫자까지 도달했을 때
        if(position == numbers.length - 1) {
            //여기는 조건 달성 코드
            if(preResult == target) {
                answer++;
            }
            return;
        }
        getReturn(numbers, target, position+1, preResult + numbers[position+1]);
        getReturn(numbers, target, position+1, preResult - numbers[position+1]);

    }
}