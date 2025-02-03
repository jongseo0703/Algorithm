import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int a;
        int b;
        
        a = in.nextInt();
        b = in.nextInt();
        
        if(a>0 && b>0) System.out.println(1);
        else if(a>0 && b<0) System.out.println(4);
        else if(a<0 && b>0) System.out.println(2);
        else if(a<0 && b<0) System.out.println(3);
        
    }

}