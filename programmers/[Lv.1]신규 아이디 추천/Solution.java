class Solution {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder(new_id.toLowerCase());//1
        answer = new StringBuilder(answer.toString().replaceAll("[^-_.a-z0-9]", ""));//2
        answer = new StringBuilder(answer.toString().replaceAll("[.]{2,}", "."));//3
        answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));//4
        if(answer.toString().equals("")) answer = new StringBuilder("a");//5
        if(answer.length() >= 16) {
            answer = new StringBuilder(answer.substring(0, 15));
            answer = new StringBuilder(answer.toString().replaceAll("^[.]|[.]$", ""));//6
        }
        while(answer.length() <= 2) {
            answer.append(answer.charAt(answer.length() - 1));//7
        }
        return answer.toString();
    }
}