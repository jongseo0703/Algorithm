import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        String[] s = (br.readLine()).split("");

        String[] k = {"c=","c-","dz=","d-","lj","nj","s=","z="};

        int count = 0;

        for(int i=0; i<s.length; i++) {
            if(i==s.length-1) {
                break;
            }
            for(int j=0; j<k.length; j++) {
                if(s[i].equals("0")) {
                    continue;
                }
                if((i+2)<s.length) {
                    if ((s[i] + s[i + 1] + s[i + 2]).equals("dz=")) {
                        s[i] = "0";
                        s[i + 1] = "0";
                        s[i + 2] = "0";
                        count++;
                    }
                }
                if((s[i] + s[i+1]).equals(k[j])) {
                    s[i] = "0";
                    s[i + 1] = "0";
                    count++;
                }

            }
        }

        for(int i=0; i<s.length; i++) {
            if(s[i].equals("0")) continue;
            else count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();

    }

}