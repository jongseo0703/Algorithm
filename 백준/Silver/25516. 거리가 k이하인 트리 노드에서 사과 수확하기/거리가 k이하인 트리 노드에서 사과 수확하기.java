import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static int[] appleCount;

    static int n, k;

    static int totalApple = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        isVisited = new boolean[n];
        appleCount = new int[n];

        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            appleCount[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        sb.append(totalApple);

        System.out.print(sb);

    }

    static void dfs(int node, int depth) {
        isVisited[node] = true;

        if(depth <= k) {
            totalApple += appleCount[node];
        }
        else {
            return;
        }

        for(int next : list.get(node)) {
            if(!isVisited[next]) {
                dfs(next, depth + 1);
            }
        }
    }

}