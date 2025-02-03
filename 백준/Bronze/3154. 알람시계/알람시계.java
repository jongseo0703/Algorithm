import java.io.*;

public class Main {

    // 각 숫자의 키보드 좌표를 저장하는 배열
    static int[][] keyCoordinates = {
            {3, 1}, // 0의 좌표
            {0, 0}, // 1의 좌표
            {0, 1}, // 2의 좌표
            {0, 2}, // 3의 좌표
            {1, 0}, // 4의 좌표
            {1, 1}, // 5의 좌표
            {1, 2}, // 6의 좌표
            {2, 0}, // 7의 좌표
            {2, 1}, // 8의 좌표
            {2, 2}  // 9의 좌표
    };

    // 이동 노력을 계산하는 함수
    static int effort(char a, char b) {
        int digitA = a - '0';
        int digitB = b - '0';
        int[] posA = keyCoordinates[digitA];
        int[] posB = keyCoordinates[digitB];
        return Math.abs(posA[0] - posB[0]) + Math.abs(posA[1] - posB[1]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        int targetHour = Integer.parseInt(s.split(":")[0]);
        int targetMinute = Integer.parseInt(s.split(":")[1]);

        int minEffort = Integer.MAX_VALUE;
        String bestTime = "";

        for (int i = 0; i <= 99; i++) {
            for (int j = 0; j <= 99; j++) {
                if (i % 24 == targetHour && j % 60 == targetMinute) {
                    String hourStr = String.format("%02d", i);
                    String minuteStr = String.format("%02d", j);

                    int currentEffort = 0;
                    currentEffort += effort(hourStr.charAt(0), hourStr.charAt(1));
                    currentEffort += effort(hourStr.charAt(1), minuteStr.charAt(0));
                    currentEffort += effort(minuteStr.charAt(0), minuteStr.charAt(1));

                    if (currentEffort < minEffort) {
                        minEffort = currentEffort;
                        bestTime = hourStr + ":" + minuteStr;
                    }
                }
            }
        }

        bw.write(bestTime + "\n");

        bw.flush();
        bw.close();
    }
}
