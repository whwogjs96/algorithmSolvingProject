class Solution {
    int count = 0;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visit = new boolean[picture.length][picture[0].length]; //방문 기록
        for(int x=0;x<m;x++) {
            for(int y=0;y<n;y++) {
                count = 0;
                //방문하지 않은 지점부터 영역 파악 시작
                if(!visit[x][y]) {
                    explore(visit, picture, x, y, picture[x][y]);
                    if(picture[x][y] != 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    //어디까지 같은 영역인지 확인하기 위한 함수로 재귀함수로 구성
    public void explore(boolean[][] visit, int[][] picture,int x, int y, int color) {
        if(visit[x][y]) return;

        //같은 색상인 경우
        if(color == picture[x][y]) {
            visit[x][y] = true; //방문한 경우 true
            count++;
            //조건문을 통해 에러를 방지하고 상하좌우로 움직이도록 설계
            if(x > 0) explore(visit, picture, x-1, y, color);
            if(y > 0) explore(visit, picture, x, y-1, color);
            if(x+1 < picture.length) explore(visit, picture, x+1, y, color);
            if(y+1 < picture[x].length) explore(visit, picture, x, y+1, color);
        }
    }
}