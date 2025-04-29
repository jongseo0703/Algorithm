import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String eq = br.readLine();

        String[] arr = eq.split("-");

        int sum = 0;

        String[] start = arr[0].split("\\+");

        for(int i = 0; i < start.length; i++) {
            sum += Integer.parseInt(start[i]);
        }

        for(int i = 1; i < arr.length; i++) {
            String[] arr2 = arr[i].split("\\+");
            for(int j = 0; j < arr2.length; j++) {
                sum -= Integer.parseInt(arr2[j]);
            }
        }

        sb.append(sum);

        System.out.print(sb);

    }

}