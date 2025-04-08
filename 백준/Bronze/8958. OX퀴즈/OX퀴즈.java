import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int score;
        int totalScore;

        for (int i = 0; i < T; i++) {
            score = 0;
            totalScore = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'O') {
                    score++;
                    totalScore += score;
                }
                else {
                    score = 0;
                }
            }
            sb.append(totalScore).append("\n");
        }

        System.out.print(sb);

    }

}