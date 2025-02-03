import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[9];
        int max = 0;
        int idx = 0;

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>max){
                max = arr[i];
                idx = i+1;
            }
        }
        bw.write(max+"\n"+idx);
        bw.flush();
    }
}