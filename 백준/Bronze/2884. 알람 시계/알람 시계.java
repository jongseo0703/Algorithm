import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a;
        int b;

        a = in.nextInt();
        b = in.nextInt();

        if(b>=45) {
            System.out.print(a+" "+(b-45));
        }
        else{
            if(a==0) {
                System.out.print(a+24-1+" "+(b+60-45));
            }
            else {
                System.out.print(a - 1 + " " + (b + 60 - 45));
            }
        }

    }

}