import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static Map<String, Integer> map;
    static boolean[] isVisited;

    static int n, m;

    static int idx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            String[] k = br.readLine().split(" is ");
            String a = k[0];
            String b = k[1];

            if(!map.containsKey(a)) {
                map.put(a, idx++);
                list.add(new ArrayList<>());
            }

            if(!map.containsKey(b)) {
                map.put(b, idx++);
                list.add(new ArrayList<>());
            }

            list.get(map.get(a)).add(map.get(b));
        }

        m = Integer.parseInt(br.readLine());

        for(int i = 0; i < m; i++) {
            String[] k = br.readLine().split(" is ");
            String a = k[0];
            String b = k[1];

            if(!map.containsKey(a) || !map.containsKey(b)) {
                sb.append("F").append("\n");
                continue;
            }

            int c = map.get(a);
            int d = map.get(b);

            if(bfs(c, d)) {
                sb.append("T").append("\n");
            }
            else {
                sb.append("F").append("\n");
            }
        }

        System.out.print(sb);

    }

    static boolean bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited = new boolean[idx];
        queue.add(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int curNode = queue.poll();

            if(curNode == target) {
                return true;
            }

            for(int next : list.get(curNode)) {
                if(!isVisited[next]) {
                    isVisited[next] = true;
                    queue.add(next);
                }
            }
        }
        return false;
    }

}