import java.util.StringTokenizer;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        double total_score = 0;
        double total_points = 0;
        for(int i=0; i<20; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String sub_name = st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();
            double grade_to_score=0.0;

            if(grade.equals("A+")) grade_to_score = 4.5;
            else if(grade.equals("A0")) grade_to_score = 4.0;
            else if(grade.equals("B+")) grade_to_score = 3.5;
            else if(grade.equals("B0")) grade_to_score = 3.0;
            else if(grade.equals("C+")) grade_to_score = 2.5;
            else if(grade.equals("C0")) grade_to_score = 2.0;
            else if(grade.equals("D+")) grade_to_score = 1.5;
            else if(grade.equals("D0")) grade_to_score = 1.0;
            else if(grade.equals("F")) grade_to_score = 0.0;
            else if(grade.equals("P")) total_points -= score;

            total_score += (score * grade_to_score);
            total_points += score;
        }

        bw.append(String.valueOf(total_score / total_points));

        bw.flush();
        bw.close();
    }
}
