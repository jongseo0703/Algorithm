import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		List<Integer> A = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
        
		for (int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(A);
		
		System.out.println(A.get(K-1));
	}

}
