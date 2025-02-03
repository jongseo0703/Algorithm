import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};

        int n = Integer.parseInt(br.readLine());

        String[] arr2 = new String[n];

        String k = br.readLine();
        String l = "";
        String h = "";
        int count = 0;
        int diffCount = 0;
        int findCount = 0;

        for (int i = 0; i < k.length(); i++) {
            l += k.charAt(i);
            if (i % 6 == 5) {
                arr2[count] = l;
                l = "";
                count += 1;
            }
        }

        for (int i = 0; i < arr2.length; i++) {

            findCount = 0;

            for (int j = 0; j < arr.length; j++) {

                diffCount = 0;

                if (arr[j].equals(arr2[i])) {

                    if (j == 0) h += "A";
                    else if (j == 1) h += "B";
                    else if (j == 2) h += "C";
                    else if (j == 3) h += "D";
                    else if (j == 4) h += "E";
                    else if (j == 5) h += "F";
                    else if (j == 6) h += "G";
                    else if (j == 7) h += "H";
                    break;

                }
                else {
                    for (int z = 0; z < 6; z++) {

                        if (arr[j].charAt(z) != arr2[i].charAt(z)) diffCount += 1;

                    }

                    if (diffCount == 1) {
                        if (j == 0) h += "A";
                        else if (j == 1) h += "B";
                        else if (j == 2) h += "C";
                        else if (j == 3) h += "D";
                        else if (j == 4) h += "E";
                        else if (j == 5) h += "F";
                        else if (j == 6) h += "G";
                        else if (j == 7) h += "H";
                        break;
                    }

                }

                findCount += 1;

            }

            if (findCount == 8) {
                h = (i+1)+"";
                break;
            }

        }

        bw.write(h);

        bw.flush();
        bw.close();

    }

}