import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;

    static int A, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        isVisited = new boolean[K + 1];

        sb.append(bfs(A));

        System.out.print(sb);
    }

    static int bfs(int n) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        isVisited[n] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curN = now[0];
            int cnt = now[1];

            if(curN == K) {
                return cnt;
            }

            int nextN1 = curN + 1;
            int nextN2 = curN * 2;

            if(nextN1 < K + 1) {
                if (!isVisited[nextN1]) {
                    isVisited[nextN1] = true;
                    queue.add(new int[]{nextN1, cnt + 1});
                }
            }

            if(nextN2 < K + 1) {
                if(!isVisited[nextN2]) {
                    isVisited[nextN2] = true;
                    queue.add(new int[]{nextN2, cnt + 1});
                }
            }
        }
        return -1;
    }

}