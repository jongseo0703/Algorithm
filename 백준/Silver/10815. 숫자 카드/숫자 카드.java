import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            hm.put(st.nextToken(), 0);
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++) {
            if(hm.containsKey(st.nextToken())) {
                bw.write("1"+ " ");
            }
            else {
                bw.write("0"+ " ");
            }
        }

        bw.flush();
        bw.close();

    }

}