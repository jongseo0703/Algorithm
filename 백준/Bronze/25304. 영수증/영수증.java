import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;
        int check_sum;
        int sum = 0;
        int a;
        int b;

        check_sum = in.nextInt();
        n = in.nextInt();

        for(int i=0; i<n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            sum += a*b;
        }

        if(sum == check_sum) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

}