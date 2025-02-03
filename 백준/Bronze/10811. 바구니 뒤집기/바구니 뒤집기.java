import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int temp;
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[Integer.parseInt(st.nextToken())];
        int k = Integer.parseInt(st.nextToken());

        for(int i=0; i<arr.length; i++) {
            arr[i] = i+1;
        }

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(b-a>=3) {
                for(int j=0; j<((b-a)/2)+1; j++) {
                    temp = arr[a-1+j];
                    arr[a-1+j] = arr[b-1-j];
                    arr[b-1-j] = temp;
                }

            } else {
                temp = arr[a - 1];
                arr[a - 1] = arr[b - 1];
                arr[b - 1] = temp;
            }
        }

        for(int i=0; i<arr.length; i++) {
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }

}