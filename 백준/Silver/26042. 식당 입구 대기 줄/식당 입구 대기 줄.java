import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    Queue<Integer> students = new LinkedList<>();
        
	    int line_max = 0, student_min = n;
	    
	    for(int i=0; i<n; i++) {
	    	String[] command = br.readLine().split(" ");
	    	if("1".equals(command[0])) {
	    		int student = Integer.parseInt(command[1]);
	    		students.add(student);
	    		if(line_max < students.size()) {
	    			line_max = students.size();
	    			student_min = student;
	    		} else if(line_max == students.size()) {
	    			student_min = (student_min > student) ? student : student_min;
	    		}
	    	} else {
	    		students.poll();
	    	}
	    }
	    
	    
	    br.close();
	    
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
	    bw.write(line_max + " " + student_min);

	    bw.flush();
	    bw.close();
		
	}
}
