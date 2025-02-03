import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        boolean flag = true;
        String s = br.readLine();


            for(int j=(int)('a'); j<=(int)'z'; j++) {
                for(int i=0; i<s.length(); i++) {
                    if(s.charAt(i) == (char)j) {
                        bw.append(String.valueOf(i)+" ");
                        flag = true;
                        break;
                    }
                    else flag = false;
                }
                if(flag == false) bw.append("-1"+" ");

            }

        bw.flush();
        bw.close();

    }

}