import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int m = 1;

        String k = Integer.toString(n);
        
        for (int i = 0; i < k.length() - 1; i++) {

            if(n % (10 * m) >= 5 * m) {
                n = (n / (10 * m) + 1) * (10 * m);
            }
            else n = (n / (10 * m)) * (10 * m);

            m *= 10;

        }

        System.out.println(n);

    }

}