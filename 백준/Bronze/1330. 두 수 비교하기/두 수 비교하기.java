import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int a;
        int b;

        Scanner in = new Scanner(System.in);

        a = in.nextInt();
        b = in.nextInt();

        if(a > b) System.out.println(">");
        else if(a < b) System.out.println("<");
        else if(a == b) System.out.println("==");

    }

}
