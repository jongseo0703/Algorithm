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

        int[] dirX = {-1, 1, -1 * A, A, -1 * B, B};

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int cur = now[0];
            int cnt = now[1];

            if(cur == M) {
                return cnt;
            }

            for(int i = 0; i < 6; i++) {
                int dx = cur + dirX[i];

                if(dx >= 0 && dx < 100001) {
                    if(!isVisited[dx]) {
                        isVisited[dx] = true;
                        queue.add(new int[]{dx, cnt + 1});
                    }
                }
            }

            int dx2 = cur * A;
            int dx3 = cur * B;

            if(dx2 >= 0 && dx2 < 100001) {
                if(!isVisited[dx2]) {
                    isVisited[dx2] = true;
                    queue.add(new int[]{dx2, cnt + 1});
                }
            }

            if(dx3 >= 0 && dx3 < 100001) {
                if(!isVisited[dx3]) {
                    isVisited[dx3] = true;
                    queue.add(new int[]{dx3, cnt + 1});
                }
            }
        }
        return -1;
    }

}