import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int n = Integer.parseInt(br.readLine());
        
		br.close();

		ArrayList<Integer> answer = new ArrayList<>();
		int maxCount = 2;

		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			list.add(n);
			list.add(i);

			int firstNumber = n;
			int secondNumber = i;

			while (true) {
				int temp = firstNumber - secondNumber;
				if (temp >= 0) {
					list.add(temp);
				}
				if (temp < 0) {
					break;
				}
				firstNumber = secondNumber;
				secondNumber = temp;
			}

			if (list.size() >= maxCount) {
				maxCount = list.size();
				answer = list;
			}
		}

		System.out.println(maxCount);
		for (int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}

}
