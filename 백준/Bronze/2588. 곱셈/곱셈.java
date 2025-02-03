import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a;
        int b;

        Scanner in = new Scanner(System.in);
        a = in.nextInt();
        b = in.nextInt();
        System.out.println(a*(b%10));
        System.out.println(a*((b%100)/10));
        System.out.println(a*(b/100));
        System.out.println((a*(b%10))+(a*((b%100)/10)*10)+((a*(b/100))*100));

    }
}