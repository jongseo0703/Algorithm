import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        double max=0;
        double sum=0;
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]>max) max = arr[i];
        }

        for(int i=0; i<n; i++) {
            arr[i] = (arr[i] / max)*100;
            sum+=arr[i];
        }
        bw.append(String.valueOf(sum/n));
        bw.flush();
        bw.close();
    }

}