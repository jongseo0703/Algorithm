import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;

        n = in.nextInt();

        int a;
        int b;

        for(int i=0; i<n; i++) {
            a = in.nextInt();
            b = in.nextInt();
            System.out.println(a+b);
        }


    }

}