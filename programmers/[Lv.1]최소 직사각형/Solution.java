class Solution {
    public int solution(int[][] sizes) {
        int maxA = 0;
        int maxB = 0;
        for(int i =0; i<sizes.length;i++) {
            int tempA = (sizes[i][0] > sizes[i][1]) ? sizes[i][0] : sizes[i][1];
            int tempB = (sizes[i][0] < sizes[i][1]) ? sizes[i][0] : sizes[i][1];
            maxA = (maxA > tempA) ? maxA : tempA;
            maxB = (maxB > tempB) ? maxB : tempB;
        }
        return maxA*maxB;
    }
}