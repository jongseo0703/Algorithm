import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static int[] order;

    static int N, M, R;

    static int visitedCount = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
        order = new int[N + 1];

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

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(list.get(i), Collections.reverseOrder());
        }

        bfs(R);

        for(int i = 1; i < N + 1; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.print(sb);

    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;
        order[start] = visitedCount++;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            for(int next : list.get(now)) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    order[next] = visitedCount++;
                    queue.add(next);
                }
            }
        }
    }

}