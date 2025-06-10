import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;

    static int n, m;

    static int totalCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        isVisited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1, 0);

        sb.append(totalCount);

        System.out.print(sb);

    }

    static void bfs(int node, int d) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node, d});
        isVisited[node] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curNode = now[0];
            int depth = now[1];

            if(depth >= 1 && depth <= 2) {
                totalCount++;
            }

            if(depth > 2) {
                continue;
            }

            for(int i : list.get(curNode)) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    queue.add(new int[]{i, depth + 1});
                }
            }
        }
    }

}