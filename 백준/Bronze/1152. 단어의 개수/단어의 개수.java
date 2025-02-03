import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int count=0;

        String s = br.readLine();
        String[] k = s.split(" ");
        for(int i=0; i<k.length; i++){
            if(k[i].equals("")) {
                continue;
            } else {
                count+=1;
            }
        }
        bw.append(String.valueOf(count));
        bw.flush();
        bw.close();

    }

}