import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());


        while(T-- > 0) {
            Queue<Document> queue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.offer(new Document(j, priority));
            }

            int count = 0;

            while(!(queue.isEmpty())) {
                Document current = queue.poll();
                boolean flag = false;

                for(Document i : queue) {
                    if(i.priority > current.priority) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    queue.offer(current);
                }
                else {
                    count++;
                    if(current.index == M) {
                        sb.append(count).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb);

    }

}

class Document {
    int index;
    int priority;

    Document(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}