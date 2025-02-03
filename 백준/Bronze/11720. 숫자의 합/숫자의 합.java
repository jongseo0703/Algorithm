import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int sum = 0;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String[] arr = s.split("");
        for(int i=0; i<arr.length; i++) {

            sum += Integer.parseInt(arr[i]);

        }

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();

    }

}