import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(br.readLine());
        long B = Long.parseLong(br.readLine());
        long C = Long.parseLong(br.readLine());

        long N = A * B * C;

        HashMap<Character, Integer> map = new HashMap<>();

        String k = Long.toString(N);

        for (int i = 0; i < k.length(); i++) {
            char digit = k.charAt(i);
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }

        for (int i = 0; i <= 9; i++) {
            sb.append(map.getOrDefault((char)(i+'0'), 0)).append("\n");
        }

        System.out.print(sb);

    }

}