import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static int[] depth;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1];
        depth = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        bfs(1);

        int max = depth[1];
        int maxNode = 0;
        int maxCount = 0;

        for(int i = 2; i < N + 1; i++) {
            if(max < depth[i]) {
                max = depth[i];
                maxNode = i;
            }
        }

        for(int i = 1; i < N + 1; i++) {
            if(max == depth[i]) {
                maxCount++;
            }
        }

        sb.append(maxNode+" ").append(max+" ").append(maxCount);

        System.out.print(sb);

    }

    static void bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int cur = now[0];
            int cnt = now[1];

            depth[cur] = cnt++;

            for(int next : list.get(cur)) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(new int[]{next, cnt});
                }
            }
        }
    }

}