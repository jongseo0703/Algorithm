import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int C = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i = 0; i <= C; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[C + 1];

        dfs(1);
        
        sb.append(count - 1).append("\n");
        System.out.print(sb);

    }

    static void dfs(int node) {
        visited[node] = true;
        count++;

        for(int next : list.get(node)) {
            if(!(visited[next])) {
                dfs(next);
            }
        }
    }

}