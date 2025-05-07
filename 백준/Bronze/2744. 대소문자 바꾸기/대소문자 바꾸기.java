import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = "";

        for(int i = 0; i < a.length(); i++) {
            if(Character.isUpperCase(a.charAt(i))) {
                b += Character.toLowerCase(a.charAt(i));
            }
            else {
                b += Character.toUpperCase(a.charAt(i));
            }
        }

        System.out.print(b);

    }
}