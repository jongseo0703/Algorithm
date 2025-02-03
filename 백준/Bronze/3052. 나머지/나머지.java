import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count = 0;
        int[] arr = new int[10];

        for(int i=0; i<arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[i] = arr[i] % 42;
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == arr[j]) {
                    count -= 1;
                    break;
                }
            }
                count += 1;
        }
        bw.append(String.valueOf(count));
        bw.flush();
        bw.close();
    }

}