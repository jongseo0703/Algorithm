import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int idx;
        long dist;
        public Node(int idx, long dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    static ArrayList<ArrayList<Node>> list;
    static boolean[] isVisited;

    static int N;

    static long max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.get(A).add(new Node(B, C));
            list.get(B).add(new Node(A, C));
        }

        dfs(1, 0);

        sb.append(max);

        System.out.print(sb);
    }

    static void dfs(int node, long dist) {
        isVisited[node] = true;

        if(max < dist) {
            max = dist;
        }

        for(Node next : list.get(node)) {
            if(!isVisited[next.idx]) {
                dfs(next.idx, dist + next.dist);
            }
        }
    }

}