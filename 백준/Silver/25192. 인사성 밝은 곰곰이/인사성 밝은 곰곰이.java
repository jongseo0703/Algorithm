import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            String k = br.readLine();
            if (k.equals("ENTER")) {
                set.clear();
                count--;
            }
            if (set.contains(k)) continue;
            else {
                set.add(k);
                count++;
            }
        }

        sb.append(count);

        System.out.println(sb);

    }

}