import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] isVisited;
    static int[] result;

    static int startNode;

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[N + 1];
        isVisited = new boolean[N + 1];
        list = new ArrayList<>();

        for(int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(B).add(A);
        }

        for(int i = 1; i < N + 1; i++) {
            isVisited = new boolean[N + 1];
            startNode = i;
            dfs(i);
        }

        int max = 0;
        for(int i = 1; i < N + 1; i++) {
            if(max < result[i]) {
                max = result[i];
            }
        }

        for(int i = 1; i < N + 1; i++) {
            if(result[i] == max) {
                sb.append(i).append(" ");
            }
        }

        System.out.print(sb);

    }

    static void dfs(int node) {
        isVisited[node] = true;

        for(int i : list.get(node)) {
            if(!isVisited[i]) {
                result[startNode]++;
                dfs(i);
            }
        }
    }

}