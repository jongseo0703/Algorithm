import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        long N = Long.parseLong(br.readLine());

        sb.append(factorial(N));

        System.out.println(sb);

    }

    public static long factorial(long N) {
        if (N <= 1) return 1;
        else return N * factorial(N - 1);
    }

}