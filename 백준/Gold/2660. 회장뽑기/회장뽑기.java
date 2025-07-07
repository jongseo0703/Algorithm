import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> list;
    static int[] score;

    static int N;

    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        score = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        while(true) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == -1 && y == -1) {
                break;
            }

            list.get(x).add(y);
            list.get(y).add(x);

        }

        int min = Integer.MAX_VALUE;

        for(int i = 1; i < N + 1; i++) {
            int s = bfs(i);
            score[i] = s;
            min = Math.min(min, score[i]);
        }

        sb.append(min + " ");

        for(int i = 1; i < N + 1; i++) {
            if(score[i] == min) {
                cnt++;
            }
        }

        sb.append(cnt).append("\n");

        for(int i = 1; i < N + 1; i++) {
            if(score[i] == min) {
                sb.append(i + " ");
            }
        }

        System.out.print(sb);

    }

    static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        queue.add(start);
        isVisited[start] = true;
        dist[start] = 0;

        int maxDist = 0;

        while(!queue.isEmpty()) {
            int curNode = queue.poll();

            for(int next : list.get(curNode)) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    dist[next] =  dist[curNode] + 1;
                    queue.add(next);
                    maxDist = Math.max(maxDist, dist[next]);
                }
            }
        }
        return maxDist;
    }

}