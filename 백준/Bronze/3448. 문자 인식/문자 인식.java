import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int R = 0, A = 0;
            String line;

            // 각 테스트 케이스의 입력을 처리
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                int length = line.length();
                for (int j = 0; j < length; j++) {
                    if (line.charAt(j) == '#') {
                        A += 1;
                    } else {
                        A += 1;
                        R += 1;
                    }
                }
            }

            double accuracy = 0;
            if (A > 0) {
                accuracy = (R / (double) A) * 100;
            }

            // 소수점 첫째 자리까지 반올림
            accuracy = Math.round(accuracy * 10) / 10.0;

            // 비율 출력 포맷팅
            if (accuracy % 1 == 0) {
                sb.append(String.format("Efficiency ratio is %.0f%%.\n", accuracy));
            } else {
                sb.append(String.format("Efficiency ratio is %.1f%%.\n", accuracy));
            }
        }

        // 결과를 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}