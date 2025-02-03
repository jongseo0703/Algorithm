import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] n = new int[10];
        int sum = 0;
        int sum2 = 0;

        for (int i = 0; i < 10; i++) {

            n[i] = Integer.parseInt(br.readLine());

        }

        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                sum += n[i];
                break;
            }
            sum += n[i];
            if (sum + n[i+1] >= 100) {
                sum2 += sum + n[i+1];
                break;
            }
        }

        if (sum2 != 0) {

            if (sum2 - 100 < 100 - sum) bw.write(sum2 + "\n");
            else if (sum2 - 100 == 100 - sum) bw.write(sum2 + "\n");
            else if (sum2 - 100 > 100 - sum) bw.write(sum + "\n");

        }
        else bw.write(sum + "\n");
        bw.flush();
        bw.close();

    }

}