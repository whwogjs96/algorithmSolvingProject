import java.util.*;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int ruleOfBuild;
        int buildingCount;
        sc.nextLine();
        ArrayList<Integer> result = new ArrayList<>();
        //테스트 케이스만큼 반복
        for(int i=0; i<testCase; i++){
            int completeBuildingNumber;

            StringTokenizer st = new StringTokenizer(sc.nextLine());
            //빌딩 개수, 건물 순서 규칙
            buildingCount = Integer.parseInt(st.nextToken());
            ruleOfBuild = Integer.parseInt(st.nextToken());

            int[] timeList = new int[buildingCount + 1]; //건물 건설에 걸리는 총 시간
            int[] preNode = new int[buildingCount + 1];

            StringTokenizer btv = new StringTokenizer(sc.nextLine());

            //빌딩 건설 시간
            int[] buildingConstructionTime = new int[buildingCount + 1];
            for(int buildTimeCount =1 ; btv.hasMoreTokens() ; buildTimeCount++) {
                buildingConstructionTime[buildTimeCount] = Integer.parseInt(btv.nextToken());
            }

            int [][] graph = new int[ruleOfBuild + 1][2]; //건물 건설 조건
            for(int x= 1; x<ruleOfBuild + 1 ;x++) {
                StringTokenizer rst = new StringTokenizer(sc.nextLine());
                graph[x][0] = Integer.parseInt(rst.nextToken());
                graph[x][1] = Integer.parseInt(rst.nextToken());
            }
            completeBuildingNumber = Integer.parseInt(sc.nextLine());

            ArrayList<ArrayList<Integer>> link = new ArrayList(); //연결된 빌딩

            for(int y = 0 ; y< buildingCount + 1 ; y++) link.add(new ArrayList()); //초기화
            Queue<Integer> queue = new LinkedList();
            for(int d = 1 ; d< ruleOfBuild + 1 ; d++) {
                link.get(graph[d][0]).add(graph[d][1]);
                preNode[graph[d][1]]++;
            }
            for(int d = 1 ;d<preNode.length ; d++) {
                if(preNode[d] == 0) queue.add(d);
                timeList[d] = buildingConstructionTime[d];
            }
            while (!queue.isEmpty()) {
                int from = queue.poll();
                for (int to : link.get(from)) {
                    timeList[to] = Math.max(timeList[to], timeList[from] + buildingConstructionTime[to]);
                    if(--preNode[to] == 0) queue.add(to);
                }
            }
            result.add(timeList[completeBuildingNumber]);
        }
        sc.close();
        for (int i = 0; i < result.size(); i ++) System.out.println(result.get(i));

    }
}
