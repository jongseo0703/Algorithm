import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int c;

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        if(a == b && b == c) {
            System.out.println(10000+a*1000);
        }
        else if(a == b) {
            System.out.println(1000+a*100);
        }
        else if(a == c) {
            System.out.println(1000+a*100);
        }
        else if(b == c) {
            System.out.println(1000+b*100);
        }
        else if(a != b && b != c && a != c) {
            if(a > b && a > c) {
                System.out.println(a*100);
            }
            else if(b > a && b > c) {
                System.out.println(b*100);
            }
            else if(c > a && c > b) {
                System.out.println(c*100);
            }
        }

    }

}