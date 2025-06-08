import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static ArrayList<Integer> answer;

    static int N, M, K, X;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];
        answer = new ArrayList<>();

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
        }

        bfs(X, 0);

        if(answer.isEmpty()) {
            sb.append(-1);
        }
        else {
            Collections.sort(answer);
            for(int i : answer) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);

    }

    static void bfs(int start, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, cnt});
        isVisited[start] = true;

        while(!queue.isEmpty()) {

            int[] now = queue.poll();
            int currIndex = now[0];
            int currCnt = now[1];

            if(currCnt == K) {
                answer.add(currIndex);
                continue;
            }

            for(int i : list.get(currIndex)) {

                if(!isVisited[i]) {
                    isVisited[i] = true;
                    queue.add(new int[]{i, currCnt + 1});
                }
            }

        }
    }

}