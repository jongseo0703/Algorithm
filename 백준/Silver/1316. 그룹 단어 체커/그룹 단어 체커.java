import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int checkCount = 0;

        String s;
        int a;
        int b;
        boolean flag = true;

        for (int i = 0; i < N; i++) {

            s = br.readLine();
            char[] chars = s.toCharArray();
            flag = true;

            for (int j = 0; j < chars.length; j++) {
                a = 0;
                b = 0;
                for (int k = j + 1; k < chars.length; k++) {
                    if (chars[j] == chars[k]) {
                        a = j;
                        b = k;
                        if (Math.abs(a - b) > 1) {
                            flag = false;
                            break;
                        }
                        else break;

                    }

                }

                if (flag == false) break;

            }
            if (flag == true) {
                checkCount++;
            }

        }

        bw.write(checkCount + "\n");
        bw.flush();
        bw.close();

    }

}