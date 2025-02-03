import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] totalFruits = new int[3];

        for (int i = 0; i < totalFruits.length; i++) {
            totalFruits[i] = Integer.parseInt(st.nextToken(" "));
        }

        st = new StringTokenizer(br.readLine());

        int[] fruits = new int[3];

        for (int i = 0; i < fruits.length; i++) {
            fruits[i] = Integer.parseInt(st.nextToken(" "));
        }

        double min = (double)totalFruits[0] / (double)fruits[0];
        int maxNum = 0;

        for (int i = 1; i < fruits.length; i++) {
            if (((double)totalFruits[i] / (double)fruits[i]) < min) {
                min = (double)totalFruits[i] / (double)fruits[i];
                maxNum = i;
            }
        }
        
        for (int i = 0; i < fruits.length; i++) {
            bw.write((totalFruits[i] - fruits[i] * min) + " ");
        }

        bw.flush();
        bw.close();

    }

}