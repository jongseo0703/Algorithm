import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        int count = 0;
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        int k = in.nextInt();

        for(int i=0; i<n; i++) {
            if(arr[i] == k) {
                count++;
            }
        }
        System.out.println(count);
    }


}