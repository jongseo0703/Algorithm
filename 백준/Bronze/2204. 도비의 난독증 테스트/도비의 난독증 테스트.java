import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            String[] arr = new String[n];
            String[] arr2 = new String[n];

            for (int i = 0; i < n; i++) {
                String k = "";
                arr[i] = br.readLine();
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) < 'a') {
                        k += (char) (arr[i].charAt(j) + ('a' - 'A'));
                    } else {
                        k += arr[i].charAt(j);
                    }
                }
                arr2[i] = k;
            }

            String minStr = arr2[0];
            String minStr2 = arr[0];  // minStr에 대응하는 원본 문자열을 초기화

            for (int i = 1; i < n; i++) {
                boolean isSmaller = false;
                for (int j = 0; j < Math.min(arr2[i].length(), minStr.length()); j++) {
                    if (arr2[i].charAt(j) < minStr.charAt(j)) {
                        isSmaller = true;
                        break;
                    } else if (arr2[i].charAt(j) > minStr.charAt(j)) {
                        break;
                    }
                }
                if (isSmaller || (arr2[i].length() < minStr.length() && arr2[i].startsWith(minStr.substring(0, arr2[i].length())))) {
                    minStr = arr2[i];
                    minStr2 = arr[i];
                }
            }

            bw.write(minStr2 + "\n");
        }

        bw.flush();
        bw.close();
    }
}