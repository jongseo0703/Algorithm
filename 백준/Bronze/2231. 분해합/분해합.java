import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int num = 0;
        boolean flag = false;

        for (int i = 0; i < N; i++) {
            int len = Integer.toString(i).length();
            sum = 0;
            for (int j = 0; j < len; j++) {
                sum += Integer.toString(i).charAt(j) - '0';
            }
            if (i + sum == N) {
                flag = true;
                num = i;
                break;
            }
        }

        if (flag) bw.write(num + "\n");
        else bw.write("0\n");

        bw.flush();
        bw.close();


    }

}