import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr_1 = new int[a][b];
        int[][] arr_2 = new int[a][b];

        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<b; j++) {
                arr_1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<a; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<b; j++) {
                arr_2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<a; i++) {
            for(int j=0; j<b; j++) {
                bw.write(arr_1[i][j]+arr_2[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

}