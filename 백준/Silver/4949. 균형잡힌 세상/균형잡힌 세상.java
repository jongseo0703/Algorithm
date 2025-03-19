import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true) {
            Stack<Character> stack = new Stack<Character>();
            String k = br.readLine();
            boolean state = true;
            if (k.equals(".")) break;
            for (int i = 0; i < k.length(); i++) {
                if (k.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    }
                    else {
                        state = false;
                        break;
                    }
                }
                else if (k.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    }
                    else {
                        state = false;
                        break;
                    }
                }
                else if (k.charAt(i) == '(' || k.charAt(i) == '[') {
                    stack.push(k.charAt(i));
                }
            }

            if (!state || !stack.isEmpty()) sb.append("no").append("\n");
            else sb.append("yes").append("\n");
        }

        System.out.println(sb);

    }

}