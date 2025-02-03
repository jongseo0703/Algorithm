import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = b;

        for(int i=a; i<=b; i++) {

            if(i == 1) {
                continue;
            }

            int count = 0;

            for(int j=2; j<i; j++) {
                if(i % j == 0) count+=1;
            }
            if(count == 0) {
                sum += i;
                if(i < min) min = i;
            }

        }

        if(sum == 0 || b == 1) {
            bw.write("-1"+"\n");
        }
        else {
            bw.write(sum + "\n");
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
    }

}