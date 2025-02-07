import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String num = st.nextToken();

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < num.length(); i++) {
            list.add(num.charAt(i) - '0');
        }

        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            bw.write(list.get(i) + "");
        }

        bw.flush();
        bw.close();

    }

}