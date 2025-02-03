import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String binary = br.readLine();
        StringBuilder octal = new StringBuilder();

        int len = binary.length();
        int remainder = len % 3;

        // 첫 번째 1, 2자리 처리
        if (remainder != 0) {
            int num = 0;
            for (int i = 0; i < remainder; i++) {
                num = num * 2 + (binary.charAt(i) - '0');
            }
            octal.append(num);
        }

        // 나머지 3자리씩 처리
        for (int i = remainder; i < len; i += 3) {
            int num = 0;
            num += (binary.charAt(i) - '0') * 4;
            num += (binary.charAt(i + 1) - '0') * 2;
            num += (binary.charAt(i + 2) - '0');
            octal.append(num);
        }

        bw.write(octal.toString());
        bw.flush();
        bw.close();
    }
}
