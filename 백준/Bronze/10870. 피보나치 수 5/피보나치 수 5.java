import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        sb.append(pibonaci(N));

        System.out.println(sb);

    }

    public static int pibonaci(int N) {
        if (N == 1) return 1;
        else if (N == 0) return 0;
        else return pibonaci(N - 1) + pibonaci(N - 2);
    }

}