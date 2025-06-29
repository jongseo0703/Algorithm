import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {-1, 1};

    static int[] dist = new int[100001];

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, Integer.MAX_VALUE);

        sb.append(bfs(N));

        System.out.print(sb);

    }

    static int bfs(int start) {
        Deque<Integer> deque = new ArrayDeque<>();
        dist[N] = 0;
        deque.addFirst(N);

        while(!deque.isEmpty()) {
            int now = deque.pollFirst();

            if(now == M) {
                return dist[now];
            }

            int dx2 = now * 2;

            if(dx2 >= 0 && dx2 < 100001 && dist[now] < dist[dx2]) {
                dist[dx2] = dist[now];
                deque.addFirst(dx2);
            }

            for(int i = 0; i < 2; i++) {
                int dx1 = now + dirX[i];

                if(dx1 >= 0 && dx1 < 100001 && dist[now] + 1 < dist[dx1]) {
                    dist[dx1] = dist[now] + 1;
                    deque.addLast(dx1);
                }
            }

        }
        return -1;
    }

}