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

        HashMap<String, Integer> map = new HashMap<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 1);
        }

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (map.get(name) != null && map.get(name) == 1) {
                count++;
                list.add(name);
            }
        }

        Collections.sort(list);

        bw.write(count+"\n");
        for (String i : list) {
            bw.write(i+"\n");
        }

        bw.flush();
        bw.close();

    }

}