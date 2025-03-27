import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int k = 1;

        for (int i = 1; i <= N; i++) {
            k *= i;
        }

        sb.append(k);

        System.out.println(sb);

    }

}