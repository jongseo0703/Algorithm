import java.io.*;
import java.util.*;

public class Main {
    static int[] dirX = {0, 0, -1, 1, 0, 0};
    static int[] dirY = {-1, 1, 0, 0, 0, 0};
    static int[] dirZ = {0, 0, 0, 0, -1, 1};

    static char[][][] map;
    static boolean[][][] isVisited;

    static int L, R, C;

    static class Node {
        int x, y, z;
        int time;
        public Node(int z, int y, int x, int time) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];
            isVisited = new boolean[L][R][C];

            int startZ = 0;
            int startY = 0;
            int startX = 0;

            for(int z = 0; z < L; z++) {
                for(int y = 0; y < R; y++) {
                    String k = br.readLine();
                    for(int x = 0; x < C; x++) {
                        map[z][y][x] = k.charAt(x);
                        if(map[z][y][x] == 'S') {
                            startZ = z;
                            startY = y;
                            startX = x;
                        }
                    }
                }
                br.readLine();
            }

            int result = bfs(startZ, startY, startX);

            if(result == -1) {
                sb.append("Trapped!").append("\n");
            }
            else {
                sb.append("Escaped in " + result + " minute(s).").append("\n");
            }

        }

        System.out.print(sb);

    }

    static int bfs(int z, int y, int x) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(z, y, x, 0));
        isVisited[z][y][x] = true;

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if(map[now.z][now.y][now.x] == 'E') {
                return now.time;
            }

            for(int i = 0; i < 6; i++) {
                int dz = now.z + dirZ[i];
                int dy = now.y + dirY[i];
                int dx = now.x + dirX[i];
                int curTime = now.time;

                if(checkArray(dz, dy, dx)) {
                    if(!isVisited[dz][dy][dx] && map[dz][dy][dx] != '#') {
                        queue.add(new Node(dz, dy, dx, curTime + 1));
                        isVisited[dz][dy][dx] = true;
                    }
                }
            }
        }
        return -1;
    }

    static boolean checkArray(int dz, int dy, int dx) {
        if(dz >= 0 && dy >= 0 && dx >= 0 && dz < L && dy < R && dx < C) {
            return true;
        }
        else {
            return false;
        }
    }

}