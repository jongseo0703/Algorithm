import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String k = "";
        boolean flag = true;

        while (true) {
            String n = br.readLine();
            flag = true;
            if(n.equals("0")) break;
            String[] arr = n.split("");

            for (int i = 0; i < (arr.length / 2) + 1; i++) {
                if(!(arr[i].equals(arr[arr.length-1-i]))) flag = false;
            }

            if(flag) bw.write("yes"+"\n");
            else bw.write("no"+"\n");


        }

        bw.flush();
        bw.close();

    }

}