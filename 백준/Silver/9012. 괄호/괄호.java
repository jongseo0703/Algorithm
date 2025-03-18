import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            boolean isValid = true;

            for (int k = 0; k < s.length(); k++) {
                char ch = s.charAt(k);

                if (ch == '(') {
                    stack.push(ch);
                } 
                else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } 
                    else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && stack.isEmpty()) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.println(sb);

    }

}