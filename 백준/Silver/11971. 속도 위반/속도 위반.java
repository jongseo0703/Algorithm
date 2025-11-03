import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[100]; 
        
        int idx = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int road = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            for(int j = idx; j < idx + road; j++) {
                arr[j] = limit; 
            }
            
            idx += road; 
        }

        idx = 0;
        
        int max = 0;
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int dist = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());

            for(int j = idx; j < idx + dist; j++) {
                if(arr[j] < speed && speed - arr[j] > max) {
                    max = speed - arr[j];
                    break;
                }
            }
            idx += dist;
        }
        System.out.println(max);
    }
}
