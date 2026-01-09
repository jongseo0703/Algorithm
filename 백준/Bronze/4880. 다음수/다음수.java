import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
            
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (A == 0 && B == 0 && C == 0)
				break;

			int N = B - A;
			int M = C - B;
			
			System.out.println((N == M) ? ("AP " + (C + M)) : ("GP " + (C + (M * (M / N)))));
		}
	}
}
