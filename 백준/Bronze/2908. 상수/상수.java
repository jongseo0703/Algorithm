import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String s = br.readLine();

        st = new StringTokenizer(s," ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a = (a%10)*100 + ((a%100)/10)*10 + (a/100);
        b = (b%10)*100 + ((b%100)/10)*10 + (b/100);

        if(a>b) {
            bw.append(String.valueOf(a));
        }
        else {
            bw.append(String.valueOf(b));
        }
        
        bw.flush();
        bw.close();


    }

}