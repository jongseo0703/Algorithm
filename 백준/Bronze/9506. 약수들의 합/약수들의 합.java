import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        BufferedWriter bw = new BufferedWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        while(true) {
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken("\n"));
            if(n == -1) break;
            for(int i = 1; i < n; i++) {
                if(n % i == 0) sum += i;
            }
            if(sum == n) {
                bw.write(n+" = 1");
                for(int i = 2; i < n; i++) {
                    if(n % i == 0) bw.write(" + "+i);
                }
                bw.write("\n");
            }
            else {
                bw.write(n+" is NOT perfect."+"\n");
            }
        }
        bw.flush();
        bw.close();

    }

}