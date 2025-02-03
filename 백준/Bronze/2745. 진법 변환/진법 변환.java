import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String[] k = (st.nextToken()).split("");
        int n = Integer.parseInt(st.nextToken());
        int sum = 0;
        int multi = 1;
        String[] l = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] a = new int[l.length];

        for(int i=0; i<l.length; i++) {
            switch(l[i]) {
                case "0" : a[i] = 0; break;
                case "1" : a[i] = 1; break;
                case "2" : a[i] = 2; break;
                case "3" : a[i] = 3; break;
                case "4" : a[i] = 4; break;
                case "5" : a[i] = 5; break;
                case "6" : a[i] = 6; break;
                case "7" : a[i] = 7; break;
                case "8" : a[i] = 8; break;
                case "9" : a[i] = 9; break;
                case "A" : a[i] = 10; break;
                case "B" : a[i] = 11; break;
                case "C" : a[i] = 12; break;
                case "D" : a[i] = 13; break;
                case "E" : a[i] = 14; break;
                case "F" : a[i] = 15; break;
                case "G" : a[i] = 16; break;
                case "H" : a[i] = 17; break;
                case "I" : a[i] = 18; break;
                case "J" : a[i] = 19; break;
                case "K" : a[i] = 20; break;
                case "L" : a[i] = 21; break;
                case "M" : a[i] = 22; break;
                case "N" : a[i] = 23; break;
                case "O" : a[i] = 24; break;
                case "P" : a[i] = 25; break;
                case "Q" : a[i] = 26; break;
                case "R" : a[i] = 27; break;
                case "S" : a[i] = 28; break;
                case "T" : a[i] = 29; break;
                case "U" : a[i] = 30; break;
                case "V" : a[i] = 31; break;
                case "W" : a[i] = 32; break;
                case "X" : a[i] = 33; break;
                case "Y" : a[i] = 34; break;
                case "Z" : a[i] = 35; break;
            }
        }

        for(int j=k.length-1; j>=0; j--) {
            multi = 1;
            for(int m=j; m>0; m--) {
                multi *= n;
            }

            for(int i=0; i<l.length; i++) {
                if(k[k.length-1-j].equals(l[i])) {
                    sum += a[i] * multi;
                }
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

}