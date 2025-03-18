import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            int k = Integer.parseInt(br.readLine());
            if(k == 0) {
                stack.pop();
            }
            else {
                stack.add(k);
            }

        }

        int sum = 0;
        int size = stack.size();

        for (int i = 0; i < size; i++) {
            sum += stack.get(i);
        }

        sb.append(sum);

        System.out.println(sb);

    }

}