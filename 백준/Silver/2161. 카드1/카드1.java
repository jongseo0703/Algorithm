import java.io.*;
import java.util.*;

public class Main {
    static Deque<Integer> deque;
    static Queue<Integer> queue;
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        n = Integer.parseInt(br.readLine());
        
        deque = new LinkedList<>();
        queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            deque.addLast(i);
        }
        
        while (deque.size() > 1) {
            queue.add(deque.removeFirst());
            deque.addLast(deque.removeFirst());
        }
        
        for (int i : queue) {
            sb.append(i + " ");
        }
        sb.append(deque.remove());
        System.out.print(sb);
    }
}
