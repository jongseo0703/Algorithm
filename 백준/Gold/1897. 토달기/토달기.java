import java.io.*;
import java.util.*;

public class Main {
  static List<String> dict;
  static boolean[] isVisited;

  static int d;
  static String word;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringBuilder sb = new StringBuilder();

    StringTokenizer st;

    st = new StringTokenizer(br.readLine());

    d = Integer.parseInt(st.nextToken());
    word = st.nextToken();

    dict = new ArrayList<>();
    isVisited = new boolean[d];

    for(int i = 0; i < d; i++) {
      dict.add(br.readLine());
    }

    String longest = bfs();

    sb.append(longest);

    System.out.print(sb);

  }

  static String bfs() {
    Queue<String> queue = new LinkedList<>();
    queue.add(word);
    String longest = word;

    while(!queue.isEmpty()) {
      String cur = queue.poll();

      for(int i = 0; i < d; i++) {
        if(!isVisited[i]) {
          String next = dict.get(i);

          if(canTransform(cur, next)) {
            isVisited[i] = true;
            queue.add(next);

            if(next.length() > longest.length()) {
              longest = next;
            }
          }
        }
      }
    }

    return longest;
  }

  static boolean canTransform(String cur, String next) {
    if(cur.length() + 1 != next.length()) {
      return false;
    }

    int i = 0, j = 0, diff = 0;
    while(i < cur.length() && j < next.length()) {
      if(cur.charAt(i) == next.charAt(j)) {
        i++;
        j++;
      }
      else {
        diff++;
        j++;

        if(diff > 1) {
          return false;
        }
      }
    }

    return true;
  }

}