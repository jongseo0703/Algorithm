import java.io.*;
import java.util.*;

public class Main {
    static int[] map;
    static boolean[] isVisited;

    static int N;
    static int a, b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1];
        isVisited = new boolean[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        sb.append(bfs(a));

        System.out.print(sb);

    }

    static int bfs(int start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curN = now[0];
            int cnt = now[1];

            if(curN == b) {
                return cnt;
            }

            int jump = map[curN];

            for(int next = curN + jump; next < N + 1; next += jump) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                }
            }

            for(int next = curN - jump; next >= 1; next -= jump) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                }
            }
        }
        return -1;
    }

}