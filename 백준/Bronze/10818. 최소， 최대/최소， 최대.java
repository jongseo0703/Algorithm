import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        int min = arr[0];

        for(int i=1; i<n; i++) {

            if(arr[i] > max) max = arr[i];
            if(arr[i] < min) min = arr[i];

        }

        bw.append(String.valueOf(min)+" "+String.valueOf(max));

        bw.flush();
        bw.close();


    }

}