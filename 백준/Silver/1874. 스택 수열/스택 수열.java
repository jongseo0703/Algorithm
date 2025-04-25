import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = 1;

        boolean flag = true;

        for(int i = 0; i < n; i++) {
            int target = arr[i];

            while(num <= target) {
                stack.push(num++);
                sb.append("+\n");
            }

            if(stack.peek() == target) {
                stack.pop();
                sb.append("-\n");
            }
            else {
                flag = false;
                break;
            }
        }

        if(flag) System.out.print(sb);
        else System.out.print("NO");

    }

}