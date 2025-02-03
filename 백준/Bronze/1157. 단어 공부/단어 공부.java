import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] alpha_count = new int[26];

        for (int i = 0; i < alpha_count.length; i++) {
            alpha_count[i] = 0;
        }

        String[] s = (br.readLine()).split("");

        for(int i=0; i<s.length; i++) {

            if(s[i].equals("a") || s[i].equals("A")) alpha_count[0] += 1;
            else if(s[i].equals("b") || s[i].equals("B")) alpha_count[1] += 1;
            else if(s[i].equals("c") || s[i].equals("C")) alpha_count[2] += 1;
            else if(s[i].equals("d") || s[i].equals("D")) alpha_count[3] += 1;
            else if(s[i].equals("e") || s[i].equals("E")) alpha_count[4] += 1;
            else if(s[i].equals("f") || s[i].equals("F")) alpha_count[5] += 1;
            else if(s[i].equals("g") || s[i].equals("G")) alpha_count[6] += 1;
            else if(s[i].equals("h") || s[i].equals("H")) alpha_count[7] += 1;
            else if(s[i].equals("i") || s[i].equals("I")) alpha_count[8] += 1;
            else if(s[i].equals("j") || s[i].equals("J")) alpha_count[9] += 1;
            else if(s[i].equals("k") || s[i].equals("K")) alpha_count[10] += 1;
            else if(s[i].equals("l") || s[i].equals("L")) alpha_count[11] += 1;
            else if(s[i].equals("m") || s[i].equals("M")) alpha_count[12] += 1;
            else if(s[i].equals("n") || s[i].equals("N")) alpha_count[13] += 1;
            else if(s[i].equals("o") || s[i].equals("O")) alpha_count[14] += 1;
            else if(s[i].equals("p") || s[i].equals("P")) alpha_count[15] += 1;
            else if(s[i].equals("q") || s[i].equals("Q")) alpha_count[16] += 1;
            else if(s[i].equals("r") || s[i].equals("R")) alpha_count[17] += 1;
            else if(s[i].equals("s") || s[i].equals("S")) alpha_count[18] += 1;
            else if(s[i].equals("t") || s[i].equals("T")) alpha_count[19] += 1;
            else if(s[i].equals("u") || s[i].equals("U")) alpha_count[20] += 1;
            else if(s[i].equals("v") || s[i].equals("V")) alpha_count[21] += 1;
            else if(s[i].equals("w") || s[i].equals("W")) alpha_count[22] += 1;
            else if(s[i].equals("x") || s[i].equals("X")) alpha_count[23] += 1;
            else if(s[i].equals("y") || s[i].equals("Y")) alpha_count[24] += 1;
            else if(s[i].equals("z") || s[i].equals("Z")) alpha_count[25] += 1;

        }

        int max_count = 0;
        int max_count_index = 0;
        char k = '0';

        for(int i=0; i<alpha_count.length; i++) {
            if(alpha_count[i] > max_count) {
                max_count = alpha_count[i];
                max_count_index = i;
                k = (char) (65 + max_count_index);
            } else if(alpha_count[i] == max_count) {
                k = '?';
            }
        }
        System.out.println(k);
        bw.flush();
        bw.close();
    }
}
