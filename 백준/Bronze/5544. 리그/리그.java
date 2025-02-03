import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] points = new int[N + 1];

        int matchCount = N * (N - 1) / 2;
        for (int i = 0; i < matchCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            if (C > D) {
                points[A] += 3;
            } else if (C < D) {
                points[B] += 3;
            } else {
                points[A] += 1;
                points[B] += 1;
            }
        }

        List<Integer> teamList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            teamList.add(i);
        }

        teamList.sort((a, b) -> {
            if (points[b] != points[a]) {
                return Integer.compare(points[b], points[a]);
            } else {
                return Integer.compare(a, b);
            }
        });

        int[] ranks = new int[N + 1];
        int currentRank = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0 && points[teamList.get(i)] == points[teamList.get(i - 1)]) {
                ranks[teamList.get(i)] = ranks[teamList.get(i - 1)];
            } else {
                ranks[teamList.get(i)] = currentRank;
            }
            currentRank++;
        }

        for (int i = 1; i <= N; i++) {
            bw.write(ranks[i] + "\n");
        }

        bw.flush();
        bw.close();
    }
}