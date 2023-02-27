class Solution {
    
    boolean[] isVisit;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        isVisit = new boolean[dungeons.length];
        permutation(dungeons, k, 1);
        return max;
    }
    
    public void permutation(int[][] dungeons, int k, int depth) {
        for(int i =0; i< dungeons.length; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                if(k >= dungeons[i][0]) { //dungeons[I][0]은 i의 최소 피로도, k는 현재 피로도
                    max = Math.max(max, depth);
                    permutation(dungeons, k - dungeons[i][1], depth+1);
                }
                isVisit[i] = false;
            }
        }
    }
}