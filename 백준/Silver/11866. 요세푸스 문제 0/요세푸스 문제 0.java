import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        sb.append("<");
        while (true) {
            if (queue.isEmpty()) break;
            for (int i = 0 ; i < K - 1; i++) {
                int val = queue.poll();
                queue.offer(val);
            }

            if (queue.size() == 1) sb.append(queue.poll()).append(">");
            else sb.append(queue.poll()).append(", ");
        }

        System.out.println(sb);

    }

}
