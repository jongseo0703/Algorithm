import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited = new boolean[100001];

    static int A, B, N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb.append(bfs(N));

        System.out.print(sb);

    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int cur = now[0];
            int cnt = now[1];

            int[] dirX = {cur -1, cur + 1, cur -1 * A, cur + A, cur -1 * B, cur + B, cur * A, cur * B};

            if(cur == M) {
                return cnt;
            }

            for(int i = 0; i < 8; i++) {
                int dx = dirX[i];

                if(dx >= 0 && dx < 100001) {
                    if(!isVisited[dx]) {
                        isVisited[dx] = true;
                        queue.add(new int[]{dx, cnt + 1});
                    }
                }
            }
        }
        return -1;
    }

}