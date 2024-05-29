import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static boolean[] isVisit;
    public static boolean[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);//정점의 개수
        int M = Integer.parseInt(line[1]);//간선의 개수
        int V = Integer.parseInt(line[2]);//시작할 정점의 번호
        edges = new boolean[N+1][N+1];

        for(int i = 0; i<M ; i++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            edges[a][b] = true;
            edges[b][a] = true;
        }
        isVisit = new boolean[N+1];
        dfs(V, N);
        System.out.println();
        isVisit = new boolean[N+1];
        bfs(V, N);
    }

    public static void dfs(int index, int N) {
        isVisit[index] = true;
        System.out.print(index+" ");
        for(int i = 1;i<=N ; i++) {
            if(edges[index][i] && !isVisit[i]) dfs(i, N);
        }
    }

    public static void bfs(int index, int N) {
        Queue<Integer> q = new LinkedList<>();

        q.add(index);
        isVisit[index] = true;

        while (!q.isEmpty()) {
            index = q.poll();
            System.out.print(index + " ");
            for (int i = 1; i <= N; i++) {
                if (edges[index][i] && !isVisit[i]) {
                    q.add(i);
                    isVisit[i] = true;
                }
            }
        }
    }
}