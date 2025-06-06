import java.io.*;
import java.util.*;

public class Main {
    static long A, B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        sb.append(bfs(A));

        System.out.print(sb);

    }

    static int bfs(long A) {
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{A, 1});

        while(!queue.isEmpty()) {
            long[] now = queue.poll();

            long N = now[0];
            long cnt = now[1];

            if(N == B) {
                return (int)cnt;
            }

            long n1 = N * 2;
            long n2 = N * 10 + 1;

            if(n1 <= B) {
                queue.add(new long[]{n1, cnt + 1});
            }
            if(n2 <= B) {
                queue.add(new long[]{n2, cnt + 1});
            }
        }
        return -1;
    }

}