import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());
        String[] a = s.split("");
        bw.write(a[n-1]);
        bw.flush();
        bw.close();
    }

}