import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 100001;
    static int[] visited = new int[MAX];

    static int N, K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        sb.append(bfs(N));

        System.out.print(sb);
    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == K) {
                return visited[now] - 1;
            }

            int[] nextStep = {now - 1, now + 1, now * 2};

            for(int next : nextStep) {
                if(next >= 0 && next < MAX && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    queue.add(next);
                }
            }

        }
        return -1;
    }
}