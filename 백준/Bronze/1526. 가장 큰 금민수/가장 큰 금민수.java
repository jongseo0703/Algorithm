import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int num = 0;
        String k = "";

        for (int i = 1; i <= n; i++) {

            k = Integer.toString(i);
            if (k.contains("0") || k.contains("1") || k.contains("2") || k.contains("3") || k.contains("5") || k.contains("6") || k.contains("8") || k.contains("9")) continue;
            else num = i;

        }

        bw.write(num + "\n");
        bw.flush();
        bw.close();

    }

}