class Solution {
    public int solution(String name) {
        int answer = 0;
        for(int i=0;i<name.length();i++) { //알파벳 맞추기
            char alphabet = name.charAt(i);
            answer+=Math.min((alphabet - 'A'),('Z' - alphabet)+1);
        }
        if(name.indexOf('A') == -1) answer+=(name.length()-1); //A가 없는 경우
        else {
            int move = name.length()-1;
            for(int i=0;i<name.length();i++) {
                if(name.charAt(i) == 'A') {
                    int currentA = i;
                    while(currentA < name.length() && name.charAt(currentA) == 'A') currentA++;
                    int cMove = (i - 1)*2 + name.length() - currentA;
                    move = Math.min(move,cMove);
                }
            }
            answer+=move;
        }
        return answer;
    }
}