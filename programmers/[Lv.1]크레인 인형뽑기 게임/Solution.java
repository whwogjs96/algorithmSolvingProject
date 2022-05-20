import java.util.ArrayList;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> data = new ArrayList<Integer>();
        for (int move : moves) {
            for (int j = 0; j < board.length; j++) {
                //0인 경우 비어있는 것으로 간주
                if (board[j][move - 1] != 0) {
                    //1개 이상 들어가있는 게 있는 경우 이번에 들어갈 데이터와 비교해 같으면 제거
                    if (data.size() != 0 && data.get(0).equals(board[j][move - 1])) {
                        data.remove(0);
                        answer += 2; //제거는 2개씩 이루어짐
                    } else {
                        data.add(0, board[j][move - 1]);
                    }
                    //집어올렸으면 무조건 0으로 변경해서 없는 것으로 변경
                    board[j][move - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}