import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;

        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            else return Integer.compare(o1[0], o2[0]);
        });

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);

    }

}