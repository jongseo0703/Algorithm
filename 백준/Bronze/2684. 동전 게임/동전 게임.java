import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        String[] arr2 = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};

        int[] counts = new int[8];

        String l = "";

        for (int i = 0; i < 8; i++) {
            counts[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                counts[j] = 0;
            }
            for (int k = 0; k < arr[i].length() - 2; k++) {

                l = "";

                for (int j = k; j < k + 3; j++) {
                    l += arr[i].charAt(j);
                }
                for (int j = 0; j < arr2.length; j++) {
                    if (l.equals(arr2[j])) counts[j] += 1;
                }
            }
            for (int j = 0; j < 8; j++) {
                bw.write(counts[j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();

    }

}