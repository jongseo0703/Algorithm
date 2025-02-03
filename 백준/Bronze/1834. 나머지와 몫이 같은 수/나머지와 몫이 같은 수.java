import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long sum = 0;

        for (long i = 1; i < n; i++) {
            sum += ((n * i) + i);
        }

        System.out.println(sum);

    }

}