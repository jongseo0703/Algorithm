import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            String[] k = s.split("");
            for(int j=0; j<k.length; j++) {
                for(int l=0; l<a; l++) {
                    bw.append(k[j]);
                }
            }
        bw.append("\n");
        }

        bw.flush();
        bw.close();

    }

}