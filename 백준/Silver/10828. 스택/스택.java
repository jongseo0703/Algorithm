import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if(st.hasMoreTokens()) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            }

            if(command.equals("pop")) {
                if(stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.pop()).append("\n");
            }
            else if(command.equals("size")) {
                sb.append(stack.size()).append("\n");
            }
            else if(command.equals("empty")) {
                if(stack.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
            }
            else if(command.equals("top")) {
                if(stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.peek()).append("\n");
            }
        }

        System.out.print(sb);

    }

}