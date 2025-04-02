import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        set.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            if (set.contains(name1) || set.contains(name2)) {
                set.add(name1);
                set.add(name2);
            }
        }

        sb.append(set.size());

        System.out.println(sb);

    }

}