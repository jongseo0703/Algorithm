import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {-1, 1};

    static int[] map;
    static boolean[] isVisited;

    static int n, s;

    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n];
        isVisited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        s = Integer.parseInt(br.readLine());

        dfs(s - 1);

        sb.append(count);

        System.out.print(sb);

    }

    static void dfs(int start) {
        isVisited[start] = true;
        count++;

        for(int i = 0; i < 2; i++) {
            int dx = dirX[i] * map[start] + start;

            if (checkArray(dx)) {
                if(!isVisited[dx]) {
                    dfs(dx);
                }
            }
        }
    }

    static boolean checkArray(int dx) {
        if(dx >= 0 && dx < n) {
            return true;
        }
        else {
            return false;
        }
    }

}