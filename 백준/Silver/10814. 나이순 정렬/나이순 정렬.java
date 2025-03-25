import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        String[][] arr = new String[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String age = st.nextToken();
            String name = st.nextToken();
            arr[i][0] = age;
            arr[i][1] = name;
            arr[i][2] = Integer.toString(i);
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(Integer.parseInt(o1[0]) == Integer.parseInt(o2[0])) return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
            else return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
        });

        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
        }

        System.out.println(sb);

    }

}