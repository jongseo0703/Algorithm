import java.io.*;
import java.util.*;
 
public class Main {
    
  public static void main(String args[]) throws IOException {
      
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
    int N = Integer.parseInt(br.readLine());
 
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
 
    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      pq.offer(num);
    }
 
    while (!pq.isEmpty()) {
      int num = pq.poll();
      bw.write(Integer.toString(num));
      bw.newLine();
    }
 
    bw.flush();
    bw.close();
    br.close();
  }
}
