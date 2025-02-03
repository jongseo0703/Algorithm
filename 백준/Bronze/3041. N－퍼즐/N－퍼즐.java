import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 목표 상태 배열
        char[][] goal = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', '.'}
        };

        // 목표 상태 위치 맵
        Map<Character, int[]> goalPosition = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                goalPosition.put(goal[i][j], new int[]{i, j});
            }
        }

        // 현재 상태 배열
        char[][] current = new char[4][4];
        for (int i = 0; i < 4; i++) {
            String line = br.readLine();
            for (int j = 0; j < 4; j++) {
                current[i][j] = line.charAt(j);
            }
        }

        int disarray = 0;

        // 맨해튼 거리 계산
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                char tile = current[i][j];
                if (tile != '.') {
                    int[] goalPos = goalPosition.get(tile);
                    disarray += Math.abs(i - goalPos[0]) + Math.abs(j - goalPos[1]);
                }
            }
        }

        bw.write(disarray + "\n");
        bw.flush();
        bw.close();
    }
}
