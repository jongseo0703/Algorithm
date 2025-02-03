import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        br.readLine();
        
        long sum=0;
        
        StringTokenizer st = new StringTokenizer(br.readLine().replaceAll("[a-zA-Z]", " "));
        
        while(st.hasMoreTokens()) {
            sum += Integer.parseInt(st.nextToken());
        }
        
        System.out.println(sum);
        
    }
    
}