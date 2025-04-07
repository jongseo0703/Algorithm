import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] arr = new String[3];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = br.readLine();
        }

        int intSum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]) - Integer.parseInt(arr[2]);
        int stringSum = Integer.parseInt(arr[0] + arr[1]) - Integer.parseInt(arr[2]);

        sb.append(intSum).append("\n").append(stringSum);

        System.out.print(sb);

    }

}