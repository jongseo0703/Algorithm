import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        HashMap<String, String> hm = new HashMap<>();

        String name;
        String state;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            state = st.nextToken();
            if (hm.containsKey(name)) {
                hm.remove(name);
            }
            else {
                hm.put(name, state);
            }
        }

        ArrayList<String> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for (var i : list) {
            bw.write(i + "\n");
        }

        bw.flush();
        bw.close();

    }

}