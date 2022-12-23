class Solution {
    public String solution(String rsp) {
        char[] data = rsp.toCharArray();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < data.length ; i++) {
            result.append(getWin(data[i]));
        }
        return result.toString();
    }
    
    public String getWin(char enemy) {
        if(enemy == '0') return "5";
        else if(enemy == '2') return "0";
        else return "2";
    }
}