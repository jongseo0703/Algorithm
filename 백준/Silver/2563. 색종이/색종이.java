import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int total_square = 0;
        boolean[][]  total_squares = new boolean[100][100];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int j = x; j < x+10; j++) {
                for(int k = y; k < y+10; k++) {
                    total_squares[j][k] = true;
                    if(total_squares[j][k]) {
                        continue;
                    }
                }
            }
        }

        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(total_squares[i][j]) {
                    total_square++;
                }
            }
        }



        bw.write(total_square + "\n");
        bw.flush();
        bw.close();
    }

}