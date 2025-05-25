import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> list;
    static boolean[] isVisited;

    static int N;

    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        isVisited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }

        dfs(1, 0);

        if(count % 2 == 0) {
            sb.append("No");
        }
        else {
            sb.append("Yes");
        }

        System.out.print(sb);

    }

    static void dfs(int node, int cnt) {
        isVisited[node] = true;
        boolean isLeaf = true;

        for(int i : list.get(node)) {
            if(!isVisited[i]) {
                isLeaf = false;
                dfs(i, cnt + 1);
            }
        }

        if(isLeaf && node != 1) {
            count += cnt;
        }
    }

}