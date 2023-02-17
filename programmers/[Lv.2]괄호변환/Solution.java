class Solution {
    StringBuilder result = new StringBuilder();
    public String solution(String p) {
        reviseString(p);
        return result.toString();
    }

    public boolean isCorrectBracket(String u) {
        if(u.length() ==0) return false;
        int openBracketCount = 0;
        for(int i=0;i<u.length();i++) {
            char bracket = u.charAt(i);
            if(isOpenBracket(bracket)) openBracketCount++;
            else {
                if(openBracketCount > 0) {
                    openBracketCount--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void reviseString(String v) {
        if(v.length() == 0) return;
        StringBuilder u = new StringBuilder();
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int lastIndex = 0;
        for(int i =0;i<v.length();i++) {
            char bracket = v.charAt(i);
            if(isOpenBracket(bracket)) {
                openBracketCount++;
            }
            else {
                closeBracketCount++;
            }
            u.append(bracket);
            if(openBracketCount == closeBracketCount) {
                lastIndex = i;
                break;
            }
        }
        if(isCorrectBracket(u.toString())) {
            result.append(u.toString());
        } else {
            result.append("(");
        }
            reviseString(v.substring(lastIndex+1, v.length()));
            if(!isCorrectBracket(u.toString())) {
                result.append(")");
                result.append(makeCorrectBracket(u.toString()));
            }
        
    }
    
    public String makeCorrectBracket(String u) {
        StringBuilder temp = new StringBuilder();
        for(int i=1;i<u.length()-1;i++) {
            char bracket = u.charAt(i);
            if(isOpenBracket(bracket)) temp.append(')');
            else temp.append('(');
        }
        return temp.toString();
    }
    
    public boolean isOpenBracket(char bracket) {
        if(bracket == '(') return true;
        else return false;
    }
}