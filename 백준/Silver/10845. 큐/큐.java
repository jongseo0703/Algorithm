import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Queue<Integer> queue = new LinkedList<>();

        int last = -1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                queue.offer(x);
                last = x;
            }

            if(command.equals("pop")) {
                if(queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.poll()).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(queue.size()).append("\n");
            }
            else if(command.equals("empty")) {
                if(queue.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(command.equals("front")) {
                if(queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(queue.peek()).append("\n");
            }
            else if(command.equals("back")) {
                if(queue.isEmpty()) sb.append("-1").append("\n");
                else sb.append(last).append("\n");
            }
        }

        System.out.print(sb);

    }

}