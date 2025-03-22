import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (st.hasMoreTokens()) {
                if (command.equals("1")) deque.offerFirst(Integer.parseInt(st.nextToken()));
                else deque.offerLast(Integer.parseInt(st.nextToken()));
            }

            if (command.equals("3")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollFirst()).append("\n");
            }
            else if (command.equals("4")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.pollLast()).append("\n");
            }
            else if (command.equals("5")) sb.append(deque.size()).append("\n");
            else if (command.equals("6")) {
                if (deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if (command.equals("7")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.getFirst()).append("\n");
            }
            else if (command.equals("8")) {
                if (deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.getLast()).append("\n");
            }

        }

        System.out.println(sb);

    }

}