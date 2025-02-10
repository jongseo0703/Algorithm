import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;

        HashMap<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            hm.put(br.readLine(),0);
        }

        for (int i = 0; i < M; i++) {
            if(hm.containsKey(br.readLine())) {
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }

}