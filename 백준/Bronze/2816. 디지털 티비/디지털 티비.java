import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] chanel = new String[n];

        String k = "";

        for (int i = 0; i < n; i++) {
            chanel[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {

            if (chanel[i].equals("KBS1")) {
                for (int j = i; j > 0; j--) {
                    k = chanel[j];
                    chanel[j] = chanel[j-1];
                    chanel[j-1] = k;
                    bw.write("4");
                }
                break;
            }
            else bw.write("1");
        }

        for (int i = 0; i < n; i++) {

            if (chanel[i].equals("KBS2")) {
                for (int j = i; j > 1; j--) {
                    k = chanel[j];
                    chanel[j] = chanel[j-1];
                    chanel[j-1] = k;
                    bw.write("4");
                }
                break;
            }
            else bw.write("1");
        }

        bw.flush();
        bw.close();


    }

}