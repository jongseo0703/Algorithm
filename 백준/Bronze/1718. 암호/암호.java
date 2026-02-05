import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        int bIdx = 0;
        for(int i = 0; i < A.length(); i++){
            int a = A.charAt(i) - 'a';
            int b = B.charAt(bIdx) - 'a' + 1;

            if(A.charAt(i) == ' ') {
                sb.append(" ");
            }
            else{
                sb.append((char)((26 + a - b)%26 + 'a') + "");
            }
            
            bIdx++;
            
            bIdx = bIdx % B.length();
        }

        System.out.print(sb);
    }
}
