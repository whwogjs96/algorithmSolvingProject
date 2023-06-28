import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int position;
    int move;
    Node(int position, int move) {
        this.position = position;
        this.move = move;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int balloonCount = Integer.parseInt(br.readLine());
        //int balloon[] = new int[balloonCount];
        ArrayList<Node> balloon = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0;st.hasMoreTokens();i++) {
            balloon.add(new Node(i+1,Integer.parseInt(st.nextToken())));
        }
        int move = 0;
        int location = 0;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int pos = position(balloon.size(), location + move);
            move = balloon.get(pos).move;
            location = move>0? pos-1 : pos;
            sb.append(balloon.get(pos).position).append(" ");
            balloon.remove(pos);
            if(balloon.size() == 0) break;
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static int position(int max, int location) {
        if(location<0) return position(max, location + max);
        else if(location>= max) return position(max, location - max);
        else return location;
    }
}