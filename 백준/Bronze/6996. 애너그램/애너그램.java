import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            int len1 = a.length();
            int len2 = b.length();
            count = 0;
            char[] arr1 = new char[len1];
            for (int j = 0; j < len1; j++) {
                arr1[j] = a.charAt(j);
            }
            char[] arr2 = new char[len2];
            for (int j = 0; j < len2; j++) {
                arr2[j] = b.charAt(j);
            }
            if (len1 == len2) {
                for (int j = 0; j < len1; j++) {
                    for (int k = 0; k < len2; k++) {
                        if (arr1[j] == arr2[k]) {
                            arr2[k] = '.';
                            count++;
                            break;
                        }
                    }
                }

                if (count == len1) bw.write(a + " & " + b + " are anagrams.\n");
                else bw.write(a + " & " + b + " are NOT anagrams.\n");

            }
            else bw.write(a + " & " + b + " are NOT anagrams.\n");

        }

        bw.flush();
        bw.close();

    }

}