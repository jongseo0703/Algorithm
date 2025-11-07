import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
        
		if(N > 0) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = N > 0 ? 1 : 0;
        
		int sum = 0;
		
		for(int x : arr) {
			sum += x;
			if(sum > M) {
				cnt++;
				sum = x;
			}
		}		
		System.out.println(cnt);
	}
}
