import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = 0;

        String k = "";
        while(a>0) {
            c = a%b;
            a=a/b;
            switch(c) {
                case 0: k += "0"; break;
                case 1: k += "1"; break;
                case 2: k += "2"; break;
                case 3: k += "3"; break;
                case 4: k += "4"; break;
                case 5: k += "5"; break;
                case 6: k += "6"; break;
                case 7: k += "7"; break;
                case 8: k += "8"; break;
                case 9: k += "9"; break;
                case 10: k += "A"; break;
                case 11: k += "B"; break;
                case 12: k += "C"; break;
                case 13: k += "D"; break;
                case 14: k += "E"; break;
                case 15: k += "F"; break;
                case 16: k += "G"; break;
                case 17: k += "H"; break;
                case 18: k += "I"; break;
                case 19: k += "J"; break;
                case 20: k += "K"; break;
                case 21: k += "L"; break;
                case 22: k += "M"; break;
                case 23: k += "N"; break;
                case 24: k += "O"; break;
                case 25: k += "P"; break;
                case 26: k += "Q"; break;
                case 27: k += "R"; break;
                case 28: k += "S"; break;
                case 29: k += "T"; break;
                case 30: k += "U"; break;
                case 31: k += "V"; break;
                case 32: k += "W"; break;
                case 33: k += "X"; break;
                case 34: k += "Y"; break;
                case 35: k += "Z"; break;
            }
        }

        String[] s = k.split("");
        String temp = "";
        for(int i=s.length-1; i>=0; i--) {
            bw.write(s[i]);
        }

        bw.flush();
        bw.close();

    }

}