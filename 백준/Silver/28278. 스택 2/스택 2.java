import java.util.*;
import java.io.*;

public class Main {

    public static Stack<Integer> stack = new Stack<Integer>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (st.hasMoreTokens()) {
                int input = Integer.parseInt(st.nextToken());
                stack.add(input);
            }
            buttonCase(command);
        }

        System.out.println(sb);

    }

    public static void buttonCase(int command) {
        switch(command) {
            case 2:
                if (stack.isEmpty()) sb.append("-1").append("\n");
                else {
                    sb.append(stack.pop()).append("\n");
                }
                break;
            case 3:
                sb.append(stack.size()).append("\n");
                break;
            case 4:
                if (stack.isEmpty()) sb.append("1").append("\n");
                else sb.append("0").append("\n");
                break;
            case 5:
                if (stack.isEmpty()) sb.append("-1").append("\n");
                else sb.append(stack.peek()).append("\n");
                break;
        }
    }

}