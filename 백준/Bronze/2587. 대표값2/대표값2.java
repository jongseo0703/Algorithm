import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int num[] = new int[5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            num[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int N = 0;

        for(int i = 0; i < 5; i++) {
            min = num[i];
            for(int j = i + 1; j < 5; j++) {
                if(min > num[j]) {
                    min = num[j];
                    N = num[i];
                    num[i] = min;
                    num[j] = N;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += num[i];
        }
        bw.write((sum/num.length)+"\n");
        bw.write(num[2]+"\n");
        bw.flush();
        bw.close();

    }

}