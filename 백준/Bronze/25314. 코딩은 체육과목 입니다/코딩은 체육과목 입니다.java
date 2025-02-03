import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int n;

        String k = "";

        n = in.nextInt();

        for(int i=0; i<n/4; i++) {
            k += "long ";
        }

        System.out.println(k+"int");
    }

}