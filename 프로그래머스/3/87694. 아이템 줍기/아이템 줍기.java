import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i < rectangle.length; i++) {
            minX = Math.min(minX, rectangle[i][0]);
            maxX = Math.max(maxX, rectangle[i][2]);
            minY = Math.min(minY, rectangle[i][1]);
            maxY = Math.max(maxY, rectangle[i][3]);
        }
        
        int lengthX = maxX - minX;
        int lengthY = maxY - minY;
        
        int[][] map = new int[102][102];
        boolean[][] isVisited = new boolean[102][102];
        
        for(int[] r : rectangle) {
            int x1 = r[0] * 2, y1 = r[1] * 2, x2 = r[2] * 2, y2 = r[3] * 2;
            for(int y = y1; y <= y2; y++) {
                for(int x = x1; x <= x2; x++) {
                    if(x == x1 || x == x2 || y == y1 || y == y2) {
                        if(map[y][x] != 2) {
                            map[y][x] = 1;
                        }
                    }
                    else {
                        map[y][x] = 2;
                    }
                }
            }
        }
        
        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterY, characterX, 0});
        isVisited[characterY][characterX] = true;
        
        int[] dirX = {0, 0, -1, 1};
        int[] dirY = {-1, 1, 0, 0};
        
        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            int curY = now[0];
            int curX = now[1];
            int cnt = now[2];
            
            if(curY == itemY && curX == itemX) {
                answer = cnt / 2;
            }
            
            for(int i = 0; i < 4; i++) {
                int dy = curY + dirY[i];
                int dx = curX + dirX[i];
                
                if(dy >= 0 && dy < 102 && dx >= 0 && dx < 102) {
                    if(!isVisited[dy][dx] && map[dy][dx] == 1) {
                        isVisited[dy][dx] = true;
                        queue.add(new int[]{dy, dx, cnt + 1});
                    }
                }
            }
        }
        
        return answer;
    }
}