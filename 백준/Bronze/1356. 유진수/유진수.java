import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String[] arr = s.split("");

        boolean flag = false;
        int n = 1;
        int total = 1;
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            total = total * Integer.parseInt(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(Integer.parseInt(s) > 0 && Integer.parseInt(s) < 10) {
                flag = false;
                break;
            }
            n = n * Integer.parseInt(arr[i]);
            if (n != 0) {
                if (n == (total / n)) {
                    flag = true;
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if(arr[i].equals("0")) zeroCount+=1;
        }
        if (zeroCount >= 2) flag = true;

        if (flag) {
            bw.write("YES"+"\n");
        }
        else {
            bw.write("NO"+"\n");
        }

        bw.flush();
        bw.close();

    }

}