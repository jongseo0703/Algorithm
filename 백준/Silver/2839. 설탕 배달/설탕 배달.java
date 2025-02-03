import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int basket = 0;

        while(true) {
            if(n % 5 == 0) {
                basket += n / 5;
                break;
            }
            else {
                n -= 3;
                basket++;
            }
            if(n < 0) {
                basket = -1;
                break;
            }
        }
        bw.write(basket + "\n");
        bw.flush();
        bw.close();

    }

}