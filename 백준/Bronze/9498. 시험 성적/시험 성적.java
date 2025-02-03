import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int score;

        score = in.nextInt();

        if (score>=90 && score<=100) System.out.println("A");
        else if(score<90 && score>=80) System.out.println("B");
        else if(score>=70 && score<80) System.out.println("C");
        else if(score<70 && score>=60) System.out.println("D");
        else System.out.println("F");

    }

}