import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        String k = "";

        for (int i = 0; i < arr.length; i++) {

            arr[i] = br.readLine();

        }

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) break;
            k = "";
            for (int j = 0; j < arr[i].length(); j++) {

                if (arr[i].charAt(j) == arr[i+1].charAt(j)) k += arr[i].charAt(j);
                else k += "?";

            }
            arr[i+1] = k;
        }

        bw.write(arr[n-1]+"\n");
        bw.flush();
        bw.close();

    }

}