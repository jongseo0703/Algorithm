import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int time = 0;
        String[] s = (br.readLine()).split("");

        for(int i=0; i<s.length; i++) {

            if(s[i].equals("A") || s[i].equals("B") || s[i].equals("C")) time += 3;
            else if(s[i].equals("D") || s[i].equals("E") || s[i].equals("F")) time += 4;
            else if(s[i].equals("G") || s[i].equals("H") || s[i].equals("I")) time += 5;
            else if(s[i].equals("J") || s[i].equals("K") || s[i].equals("L")) time += 6;
            else if(s[i].equals("M") || s[i].equals("N") || s[i].equals("O")) time += 7;
            else if(s[i].equals("P") || s[i].equals("Q") || s[i].equals("R") || s[i].equals("S")) time += 8;
            else if(s[i].equals("T") || s[i].equals("U") || s[i].equals("V")) time += 9;
            else if(s[i].equals("W") || s[i].equals("X") || s[i].equals("Y") || s[i].equals("Z")) time += 10;

        }

        bw.append(String.valueOf(time));
        bw.flush();
        bw.close();


    }

}