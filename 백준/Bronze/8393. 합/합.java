import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;
        int sum = 0;

        n = in.nextInt();

        for(int i=0; i<=n; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

}