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

        if(b+c<60) {
            System.out.println(a+" "+(b+c));
        }
        else {
            if(a+((b+c)/60)>=24) {
                a=a-24;
            }
            System.out.println(a+((b+c)/60)+" "+(b+c)%60);
        }

    }

}