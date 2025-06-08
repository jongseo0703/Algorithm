import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;

    static int F, S, G, U, D;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isVisited = new boolean[F + 1];

        int result = bfs(S, 0);

        if(result == -1) {
            sb.append("use the stairs");
        }
        else {
            sb.append(result);
        }

        System.out.print(sb);
    }

    static int bfs(int start, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, cnt});
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            int currentFloor = now[0];
            int nowCnt = now[1];

            if(currentFloor == G) {
                return nowCnt;
            }

            int nextFloor1 = currentFloor + U;
            int nextFloor2 = currentFloor - D;

            if(checkArray(nextFloor1)) {
                if (!isVisited[nextFloor1]) {
                    isVisited[nextFloor1] = true;
                    queue.add(new int[]{nextFloor1, nowCnt + 1});
                }
            }

            if(checkArray(nextFloor2)) {
                if (!isVisited[nextFloor2]) {
                    isVisited[nextFloor2] = true;
                    queue.add(new int[]{nextFloor2, nowCnt + 1});
                }
            }
        }
        return -1;
    }

    static boolean checkArray(int nextFloor) {
        if(nextFloor > 0 && nextFloor < F + 1) {
            return true;
        }
        else {
            return false;
        }
    }

}