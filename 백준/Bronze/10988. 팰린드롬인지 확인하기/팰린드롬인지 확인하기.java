import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count=0;
        String[] s = (br.readLine()).split("");

        for(int i=0; i<(s.length/2)+1; i++) {

            if(s[i].equals(s[s.length-1-i])) count++;

        }
        if(count==(s.length/2)+1) bw.append("1");
        else bw.append("0");


        bw.flush();
        bw.close();

    }

}