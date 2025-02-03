import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =  Integer.parseInt(br.readLine());
        int count = 0;
        int sum = 0;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            count++;
        }

        bw.write(count + "\n");
        if (arr[n - 1] > 3) bw.write("4\n");
        else bw.write("1\n");
        bw.flush();
        bw.close();

    }

}