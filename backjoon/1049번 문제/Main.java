import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int guitarString = Integer.parseInt(st.nextToken()); //기타줄의 개수
        int packCount = Integer.parseInt(st.nextToken()); //기타 브랜드 개수
        int linePack [][] = new int[packCount][2]; //각 브랜드의 정보가 담긴 배열
        String[] data = br.readLine().split(" ");
        linePack[0][0] = Integer.parseInt(data[0]);
        linePack[0][1] = Integer.parseInt(data[1]);
        int minPackPrice = linePack[0][0]; //최소 패키지 가격
        int minPiecePrice = linePack[0][1]; //최소 낱개 각겨
        for(int i = 1; i<packCount;i++){
            data = br.readLine().split(" ");
            //0번은 이미 위에서 min 값을 위해 저장했기 때문에 1부터 시작
            linePack[i][0] = Integer.parseInt(data[0]);
            linePack[i][1] = Integer.parseInt(data[1]);
            minPackPrice = Math.min(minPackPrice, linePack[i][0]);
            minPiecePrice = Math.min(minPiecePrice, linePack[i][1]);
        }
        //낱개로 6개를 산 가격이 패키지 가격보다 작다면 무조건 낱개로만 구매
        if(minPackPrice > minPiecePrice*6) {
            System.out.println(guitarString*minPiecePrice);
        } else {
            //패키지를 사고 남은 개수를 낱개 가격으로 샀을 때,
            //낱개로 사는게 패키지 하나를 사는 것 보다 비싼 경우 패키지를 하나 더 사고,
            //아닌 경우 낱개로 구매
            if((guitarString%6)*minPiecePrice > minPackPrice) {
                System.out.println((guitarString/6+1)*minPackPrice);
            } else {
                System.out.println((guitarString/6)*minPackPrice + (guitarString%6)*minPiecePrice);
            }
        }
    }
}