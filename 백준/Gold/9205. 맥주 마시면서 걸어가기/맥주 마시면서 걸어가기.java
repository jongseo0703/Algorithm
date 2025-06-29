import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int t, n;

    static Point[] points;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n + 2];
            isVisited = new boolean[n + 2];

            for(int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            sb.append(bfs() ? "happy" : "sad").append("\n");

        }

        System.out.print(sb);

    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        isVisited[0] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == n + 1) {
                return true;
            }

            for(int i = 0; i < n + 2; i++) {
                if(!isVisited[i] && distance(points[now], points[i]) <= 1000) {
                    isVisited[i] = true;
                    queue.add(i);
                }
            }
        }
        return false;
    }

    static int distance(Point a, Point b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

}