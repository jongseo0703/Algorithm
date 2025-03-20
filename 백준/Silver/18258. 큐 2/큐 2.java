import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<Integer>();

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (st.hasMoreTokens()) {
                deque.offer(Integer.parseInt(st.nextToken()));
            }

            if (command.equals("pop")) {
                if (!deque.isEmpty()) {
                    sb.append(deque.poll()).append("\n");
                }
                else sb.append("-1").append("\n");
            }
            else if (command.equals("size")) sb.append(deque.size()).append("\n");
            else if (command.equals("empty")) {
                if (deque.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if (command.equals("front")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peek()).append("\n");
            }
            else if (command.equals("back")) {
                if(deque.isEmpty()) sb.append("-1").append("\n");
                else sb.append(deque.peekLast()).append("\n");
            }
        }

        System.out.println(sb);

    }

}