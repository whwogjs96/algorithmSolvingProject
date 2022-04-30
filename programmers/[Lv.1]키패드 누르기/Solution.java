class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int currentLeft = 10; // 10은 *
        int currentRight = 12; // 12은 #
        for(int i =0; i<numbers.length;i++) {
            //맨 왼쪽 부분 버튼은 항상 왼손
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                currentLeft = numbers[i];
            }
            //맨 오른쪽 버튼들은 항상 오른손
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                currentRight = numbers[i];
            }
            //가운데 버튼일 때
            else {
                int num = numbers[i];
                if(numbers[i] == 0) num = 11; //0은 11로 변경해서 판단
                int numberRemainder = num%3;

                int leftDistance = 0;
                int rightDistance = 0;
                int tempRight = currentRight;
                if(currentRight % 3 ==0){tempRight-=2;} //오른쪽에 있는 경우 판별을 편하게 하기 위해 같은 왼쪽으로 변경해서 판단
                //둘 다 현재 위치가 중앙이 아닌 경우 무조건 한 칸은 가야함
                if(numberRemainder != currentLeft%3) leftDistance++; 
                if(numberRemainder != currentRight%3) rightDistance++;

                //위 아래로 몇 칸 이동해야하는지 판단
                leftDistance += Math.abs((num/3) - (currentLeft/3));
                rightDistance += Math.abs((num/3) - (tempRight/3));
                if(leftDistance < rightDistance) {
                    sb.append("L");
                    currentLeft = num;
                }
                else if(leftDistance > rightDistance){
                    sb.append("R");
                    currentRight = num;
                }
                //거리가 동일할 경우 왼손잡이인지 오른손잡이인지 판단
                else {
                    if(hand.equals("right")) {
                        sb.append("R");
                        currentRight = num;
                    }
                    else {
                        sb.append("L");
                        currentLeft = num;
                    }
                }
            }
        }

        return sb.toString();
    }
}