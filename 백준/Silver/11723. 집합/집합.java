import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (!st.hasMoreTokens()) {
                if (command.equals("all")) {
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                }
                else {
                    set.clear();
                }
            }
            else {
                int n = Integer.parseInt(st.nextToken());
                if (command.equals("add")) set.add(n);
                else if (command.equals("remove")) set.remove(n);
                else if (command.equals("check")) {
                    if (set.contains(n)) sb.append("1").append("\n");
                    else sb.append("0").append('\n');
                }
                else if (command.equals("toggle")) {
                    if (set.contains(n)) set.remove(n);
                    else set.add(n);
                }
            }
        }

        System.out.print(sb);

    }

}