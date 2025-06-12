import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] isVisited;

    static int N;

    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        isVisited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        sb.append(bfs(0, 0));

        System.out.print(sb);
    }

    static int bfs(int start, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, cnt});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int n = now[0];
            int count = now[1];
            int nextStep = map[n];

            if(n == N - 1) {
                return count;
            }

            for(int i = 1; i <= nextStep; i++) {
                int next = n + i;

                if(next < N) {
                    if (!isVisited[next]) {
                        isVisited[next] = true;
                        queue.add(new int[]{next, count + 1});
                    }
                }
            }
        }
        return -1;
    }

}