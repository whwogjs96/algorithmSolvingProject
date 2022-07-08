import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> nameList = new HashMap<>();
        for(String key : completion) nameList.put(key, nameList.getOrDefault(key, 0) + 1);
        for (String s : participant) {
            if (nameList.containsKey(s)) {
                if (nameList.getOrDefault(s, 0) != 0) {
                    nameList.put(s, nameList.getOrDefault(s, 0) - 1);
                } else {
                    return s;
                }
            } else {
                return s;
            }
        }
        return "";
    }
}