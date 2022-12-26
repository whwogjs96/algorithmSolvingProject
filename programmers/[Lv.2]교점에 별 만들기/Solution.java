import java.util.*;
 
public class Solution {
 
    public static int minX = Integer.MAX_VALUE;
    public static int maxX = Integer.MIN_VALUE;
    public static int minY = Integer.MAX_VALUE;
    public static int maxY = Integer.MIN_VALUE;
 
    public String[] solution(int[][] line) {
        List<PointData> list = new ArrayList<>();
        //각 선들의 만나는 지점 계산
        for(int i=0; i<line.length-1; i++) {
            for(int j=i+1; j<line.length; j++) {
                int[] data = computingLocation(line[i],line[j]);
                if(data != null) {
                    list.add(new PointData(data[0], data[1]));
                    //더 크거나 작은 값이 있으면 변경
                    minX = Math.min(minX, data[0]);
                    maxX = Math.max(maxX, data[0]);
                    minY = Math.min(minY, data[1]);
                    maxY = Math.max(maxY, data[1]);
                }
            }
        }
 
        List<String> board = new ArrayList<>();
        //일단 다 .으로 변환
        for(int i=minY; i<=maxY; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=minX; j<=maxX; j++) {
                sb.append(".");
            }
            board.add(sb.toString());
        }
        for(PointData intersection : list) {
            StringBuilder sb = new StringBuilder(board.get(Math.abs(intersection.y - maxY)));
            sb.setCharAt(Math.abs(intersection.x - minX), '*');
            board.set(Math.abs(intersection.y - maxY), sb.toString());
        }
 
        String[] answer = new String[board.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = board.get(i);
        }
        return answer;
    }
    
    public int[] computingLocation(int[] line1, int[] line2) {
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        long denominator = (a * d) - (b * c);
        if(denominator == 0) return null;//여기가 0인 경우 분모가 0이라 에러, 두 직선은 평행 또는 일치
        
        long numerator1 = (b * f) - (e * d);
        long numerator2 = (e * c) - (a * f);
        
        //무수히 많은 특정 x 및 y에서 만남
        if(numerator1 % denominator != 0 || numerator2 % denominator != 0) return null;
                
        int x = (int) (numerator1 / denominator);
        int y = (int) (numerator2 / denominator);
        int[] result = {x, y};
        return result;
    }
}

class PointData {
    int x;
    int y;
    
    PointData(int x, int y) {
        this.x = x;
        this.y = y;
    }
}