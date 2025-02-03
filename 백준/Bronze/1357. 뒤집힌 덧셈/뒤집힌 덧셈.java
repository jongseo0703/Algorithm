import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        int revX = 0;
        int revY = 0;
        int ten = 1;

        String[] arr1 = X.split("");
        String[] arr2 = Y.split("");

        String k = "";

        for (int i = 0; i < arr1.length / 2; i++) {
            k = arr1[i];
            arr1[i] = arr1[arr1.length - 1 - i];
            arr1[arr1.length - 1 - i] = k;
        }

        for (int i = 0; i < arr2.length / 2; i++) {
            k = arr2[i];
            arr2[i] = arr2[arr2.length - 1 - i];
            arr2[arr2.length - 1 -i] = k;
        }

        for (int i = 0; i < arr1.length; i++) {
            ten = 1;
            for (int j = arr1.length-1; j > i; j--) {
                ten *= 10;
            }
            revX += Integer.parseInt(arr1[i]) * ten;
        }

        for (int i = 0; i < arr2.length; i++) {
            ten = 1;
            for (int j = arr2.length-1; j > i; j--) {
                ten *= 10;
            }
            revY += Integer.parseInt(arr2[i]) * ten;
        }

        String l = Integer.toString(revX + revY);
        String[] arr3 = l.split("");
        int revZ = 0;
        for (int i = 0; i < arr3.length / 2; i++) {
            k = arr3[i];
            arr3[i] = arr3[arr3.length - 1 - i];
            arr3[arr3.length - 1 - i] = k;
        }

        for (int i = 0; i < arr3.length; i++) {
            ten = 1;
            for (int j = arr3.length-1; j > i; j--) {
                ten *= 10;
            }
            revZ += Integer.parseInt(arr3[i]) * ten;
        }

        bw.write(revZ + "\n");
        bw.flush();
        bw.close();

    }

}