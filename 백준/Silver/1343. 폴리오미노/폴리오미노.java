import java.io.*;
import java.util.*;

public class Main{
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String q = br.readLine().concat(".");
        
        String answer = "";
        
        int repeat = 0;

        for(int i = 0; i < q.length(); i++){
            char temp = q.charAt(i);
            
            if(temp == 'X') {
                repeat++;
                if(repeat == 4) {
                    answer = answer.concat("AAAA");
                    repeat = 0;
                }
            }
            else {
                if(repeat%2!=0) {
                    answer = "-1";
                    break;
                }
                else if(repeat == 2) {
                    answer = answer.concat("BB");
                    repeat=0;
                }
                if(i != q.length()-1) {
                    answer = answer.concat(".");
                }
            }
        }
        System.out.println(answer);
    }
}
