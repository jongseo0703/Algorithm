import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) {
                if(queue.isEmpty()) sb.append("0").append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else queue.offer(n);
        }

        System.out.print(sb);

    }

}