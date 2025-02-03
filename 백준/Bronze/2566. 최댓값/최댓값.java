import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] a = new int[9][9];
        int max = 0;
        int max_index_i = 0;
        int max_index_j = 0;

        for(int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if(a[i][j] >= max) {
                    max = a[i][j];
                    max_index_i = i+1;
                    max_index_j = j+1;
                }
            }
        }

        bw.append(String.valueOf(max));
        bw.newLine();
        bw.append(String.valueOf(max_index_i)+" "+String.valueOf(max_index_j));
        bw.flush();
        bw.close();
    }

}