import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(st.nextToken());
            
            if(num <= n) arr[num]++;
        }

        int answer = -1;
        
        for(int i = 0; i <= n; i++){
            
            if(arr[i] == i) answer = i;
        }

        System.out.println(answer);
    }
}
