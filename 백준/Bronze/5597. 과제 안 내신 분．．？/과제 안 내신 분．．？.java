import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[] arr = new int[31];
        int a;

        for(int i=1; i<29; i++) {
            a = Integer.parseInt(br.readLine());
            arr[a] = 1;
        }

        for(int i=1; i<arr.length; i++) {
            if(arr[i] != 1) bw.append(i+"\n");
        }

        bw.flush();
        bw.close();
    }

}