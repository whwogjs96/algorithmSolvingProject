import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[][] relationTable = new char[size][size]; //친구 관계를 기록할 배열
        for(int i = 0; i< size; i++) {
            String line = br.readLine();
            relationTable[i] = line.toCharArray();
        }
        //A와 B가 친구가 B와 C가 친구라면 A와 C는 친구
        //A와 친구인 관계 배열에 존재하는 모든 친구의 친구까지 친구로 판단
        for(int i =0; i<size;i++) {
            //중복된 친구관계는 거르기 위함
            Set<Integer> relationMember = new HashSet<>();
            for(int j = 0; j< size;j++) {
                if(relationTable[i][j] == 'Y') { //j가 친구라면
                    relationMember.add(j);
                    for(int x = 0; x<size;x++) {
                        //친구의 친구도 친구 목록에 포함
                        //현재 반복문에서 판단하는 친구는 이미 i의 친구이므로 j의 친구는 i의 친구가 됨
                        if(x != i && relationTable[j][x] == 'Y') relationMember.add(x);
                    }
                }
            }
            answer = Math.max(answer, relationMember.size());
        }
        System.out.println(answer);
    }
}