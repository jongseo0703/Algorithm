import java.io.*;

interface Main{

    static void main(String[]a) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = "";
        String regex = ".*BUG.*";

        while((str = br.readLine()) != null){

            while(str.matches(regex)) {

                str = str.replaceAll("BUG", "");
            }

            bw.write(str);
            bw.newLine();
        }

        bw.flush();
    }

}