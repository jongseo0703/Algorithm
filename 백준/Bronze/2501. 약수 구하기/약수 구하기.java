import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int min = 0;
        int count = 0;
        for(int i=1; i<=a; i++) {
            if(a%i == 0) {
                min = i;
                count += 1;
                if(count == b) break;
            }
        }
        if(count < b) min = 0;
        bw.write(min + "\n");
        bw.flush();
        bw.close();
    }

}