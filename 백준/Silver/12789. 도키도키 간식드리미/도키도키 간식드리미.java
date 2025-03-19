import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        StringBuilder sb = new StringBuilder();

        int currentCount = 1;

        Stack<Integer> stack1 = new Stack<Integer>();

        while (!queue.isEmpty()) {
            if (queue.peek() == currentCount) {
                queue.poll();
                currentCount++;
            }
            else if (!stack1.isEmpty() && stack1.peek() == currentCount) {
                stack1.pop();
                currentCount++;
            }
            else {
                stack1.push(queue.poll());
            }
        }

        while (!stack1.isEmpty() && stack1.peek() == currentCount) {
            stack1.pop();
            currentCount++;
        }

        if (stack1.isEmpty()) sb.append("Nice").append("\n");
        else sb.append("Sad").append("\n");

        System.out.println(sb);

    }

}