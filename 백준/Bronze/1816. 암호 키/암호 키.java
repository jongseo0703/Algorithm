import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {

            long num = in.nextLong();

            boolean flag = true;

            for (long j = 2; j < 1000000; j++) {
                if (num % j == 0) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if (flag) System.out.println("YES");

        }

    }

}