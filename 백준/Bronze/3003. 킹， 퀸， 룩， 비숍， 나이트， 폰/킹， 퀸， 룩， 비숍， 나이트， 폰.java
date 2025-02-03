import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int king = Integer.parseInt(st.nextToken());
        int queen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());
        int bishop = Integer.parseInt(st.nextToken());
        int knight = Integer.parseInt(st.nextToken());
        int pawn = Integer.parseInt(st.nextToken());

        bw.append((1-king)+" "+(1-queen)+" "+(2-look)+" "+(2-bishop)+" "+(2-knight)+" "+(8-pawn));

        bw.flush();
        bw.close();

    }

}