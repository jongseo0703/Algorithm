import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {

            deque.offer(new int[]{i, Integer.parseInt(st.nextToken())});

        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            int[] balloon = deque.poll();
            int num = balloon[0];
            int move = balloon[1];

            sb.append(num).append(" ");

            if (deque.isEmpty()) break;

            if (move > 0) {
                for (int i = 0; i < move - 1; i++) {
                    deque.offer(deque.poll());
                }
            } else {
                for (int i = 0; i < -move; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);

    }

}