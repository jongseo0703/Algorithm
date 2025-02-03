import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[15][15];  // Increased the array size to 15x15 to accommodate 1-indexed values
        for (int i = 1; i <= 14; i++) {  // Fill the 1st row (0th floor)
            arr[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {  // Calculate values for other floors
            for (int j = 1; j <= 14; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());

            if (a >= 0 && a <= 14 && b > 0 && b <= 14) {  // Ensure a and b are within valid range
                bw.write(arr[a][b] + "\n");
            } else {
                bw.write("Invalid input\n");  // Handle invalid input gracefully
            }
        }

        bw.flush();
        bw.close();
    }
}
