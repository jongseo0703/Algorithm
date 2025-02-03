import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }


        }

        int maxX = arr[0][0];
        int maxY = arr[0][1];
        int minX = arr[0][0];
        int minY = arr[0][1];

        for (int i = 1; i < N; i++) {
            if (arr[i][0] > maxX) maxX = arr[i][0];
            if (arr[i][0] < minX) minX = arr[i][0];
        }
        for (int i = 1; i < N; i++) {
            if (arr[i][1] > maxY) maxY = arr[i][1];
            if (arr[i][1] < minY) minY = arr[i][1];
        }
        int square = (maxX - minX) * (maxY - minY);
        bw.write(square + "\n");
        bw.flush();
        bw.close();


    }

}