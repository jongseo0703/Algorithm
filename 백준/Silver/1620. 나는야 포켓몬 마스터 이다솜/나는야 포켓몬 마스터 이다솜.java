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

        HashMap<Integer, String> pocketmon1 = new HashMap<>();
        HashMap<String, Integer> pocketmon2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pocketmon = br.readLine();
            pocketmon1.put(i, pocketmon);
            pocketmon2.put(pocketmon, i);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            try {
                bw.write(pocketmon1.get(Integer.parseInt(name)) + "\n");
            }
            catch (NumberFormatException e) {
                bw.write(pocketmon2.get(name) + "\n");
            }
        }

        bw.flush();
        bw.close();

    }

}