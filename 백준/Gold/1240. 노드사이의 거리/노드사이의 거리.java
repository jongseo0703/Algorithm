import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static List<List<Integer>> dist;
    static boolean[] isVisited;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new ArrayList<>();

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
            dist.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int depth = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);

            dist.get(x).add(depth);
            dist.get(y).add(depth);
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append("\n");
        }

        System.out.print(sb);

    }

    static int bfs(int start, int target) {
        Queue<int[]> queue = new LinkedList<>();
        isVisited = new boolean[N + 1];
        queue.add(new int[]{start, 0});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curNode = now[0];
            int d = now[1];

            if(curNode == target) {
                return d;
            }

            List<Integer> next = list.get(curNode);
            List<Integer> nextDist = dist.get(curNode);

            for(int i = 0; i < next.size(); i++) {
                int n = next.get(i);
                int w = nextDist.get(i);

                if(!isVisited[n]) {
                    isVisited[n] = true;
                    queue.add(new int[]{n, d + w});
                }
            }
        }
        return -1;
    }

}