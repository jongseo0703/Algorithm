import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int[] arr = new int[9];
        int sum = 0;
        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }

        sum %= 100;


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                        arr[i] = 0;
                        arr[j] = 0;
                        flag = false;
                        break;
                }
            }
            if (flag == false) break;
        }

        int min = 0;

        int[] arr7 = new int[7];

        for (int j = 0; j < arr7.length; j++) {

            for (int k = 0; k < arr.length; k++) {

                if (arr[k] != 0) {
                    min = arr[k];
                    break;
                }
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0 && arr[i] < min) {
                    min = arr[i];
                }
            }

            for (int l = 0; l < arr.length; l++) {
                if (arr[l] == min) arr[l] = 0;
            }

            arr7[j] = min;
        }

        for (int i = 0; i < arr7.length; i++) {
            System.out.print(arr7[i] + "\n");
        }


    }

}