import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map1 = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num1 = Integer.parseInt(st.nextToken());
            map1.put(num1, 0);
        }

        st = new StringTokenizer(br.readLine());

        int count = 0;

        for (int i = 0; i < m; i++) {
            int num2 = Integer.parseInt(st.nextToken());
            if (map1.containsKey(num2)) count++;
        }

        bw.write((n+m-2*count)+"\n");
        bw.flush();
        bw.close();

    }

}