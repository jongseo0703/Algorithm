import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String[] arr = new String[3];

        for(int i = 0; i < 3; i++) {
            String s = br.readLine();
            arr[i] = s;
        }

        for(int i = 0; i < 3; i++) {
            if(i == 2) break;
            if(arr[i].equals("FizzBuzz"));
            else if(arr[i].equals("Fizz"));
            else if(arr[i].equals("Buzz"));
            else {
                arr[i + 1] = Integer.toString(Integer.parseInt(arr[i]) + 1);
            }
        }

        int n = Integer.parseInt(arr[2]) + 1;

        if(n % 3 == 0 && n % 5 == 0) sb.append("FizzBuzz");
        else if(n % 3 == 0) sb.append("Fizz");
        else if(n % 5 == 0) sb.append("Buzz");
        else sb.append(n);

        System.out.print(sb);

    }

}