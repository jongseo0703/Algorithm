import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num[] = new int[N];

        int min = 0;

        int k = 0;

        for(int i = 0; i < num.length; i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < num.length; i++){
            min = num[i];
            for(int j = i+1; j < num.length; j++){
                if(num[j] < min){
                    min = num[j];
                    k = num[i];
                    num[i] = num[j];
                    num[j] = k;
                }
            }
        }

        for(int i = 0; i < num.length; i++){
            bw.write(num[i] + "\n");
        }

        bw.flush();
        bw.close();

    }

}