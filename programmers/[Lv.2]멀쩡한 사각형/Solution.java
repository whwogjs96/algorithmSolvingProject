class Solution {
    //이 문제는 공식이 있음
    //공식을 파악하는게 문제이므로 사실상 코딩테스트를 많이 해보거나 테스트케이스가 충분히 주어져야 풀 수 있는 문제
    public long solution(int w, int h) {
        int gcdData = gcd(w,h);
        return ((long)w * (long)h)-(long)((w/gcdData)+(h/gcdData)-1)*(long)gcdData;
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}