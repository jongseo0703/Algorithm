import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        while(true) {
            if (deque.size() == 1) break;
            deque.pop();
            deque.offerLast(deque.pop());
        }

        sb.append(deque.getFirst()).append("\n");

        System.out.println(sb);

    }

}