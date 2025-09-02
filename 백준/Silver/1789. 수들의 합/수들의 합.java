import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		long S = Long.parseLong(br.readLine());
		
		int N = 1;
        
		while(true) {
			if(S >= N) {
                S -= N;
            }
			else {
                break;
            }
            
			N++;
		}
		System.out.println(--N);
	}

}
