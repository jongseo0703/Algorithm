import java.util.*;

class Solution {
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    
    static boolean[][] isVisited;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int mapY = maps.length;
        int mapX = maps[0].length;
        
        isVisited = new boolean[mapY][mapX];
        
        answer = bfs(maps, 0, 0, mapY, mapX);
        
        return answer;
    }
    
    static int bfs(int[][] maps, int y, int x, int mapY, int mapX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x, 1});
        isVisited[y][x] = true;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int curY = now[0];
            int curX = now[1];
            int cnt = now[2];
            
            if(curY == mapY - 1 && curX == mapX - 1) {
                return cnt;
            }
            
            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];
                
                if(checkArray(dy, dx, mapY, mapX)) {
                    if(!isVisited[dy][dx] && maps[dy][dx] != 0) {
                        queue.add(new int[]{dy, dx, cnt + 1});
                        isVisited[dy][dx] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    static boolean checkArray(int dy, int dx, int mapY, int mapX) {
        if(dy >= 0 && dx >= 0 && dy < mapY && dx < mapX) {
            return true;
        }
        else {
            return false;
        }
    }
}