import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int num = 666;
        int count = 1;

        while(count != n) {

            num++;

            if(String.valueOf(num).contains("666")) {
                count++;
            }

        }

        bw.write(num+"\n");
        bw.flush();
        bw.close();

    }

}