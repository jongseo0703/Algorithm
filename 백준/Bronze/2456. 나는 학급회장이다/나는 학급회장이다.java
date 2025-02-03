import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] scores = new int[n][3];

        int stu1 = 0, stu2 = 0, stu3 = 0;
        int stu1Count1 = 0, stu1Count2 = 0, stu1Count3 = 0;
        int stu2Count1 = 0, stu2Count2 = 0, stu2Count3 = 0;
        int stu3Count1 = 0, stu3Count2 = 0, stu3Count3 = 0;

        int[][] students = new int[3][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    if (scores[i][j] == 3) {
                        students[0][0] += scores[i][j];
                        students[0][3] += 1;
                    }
                    else if (scores[i][j] == 2) {
                        students[0][0] += scores[i][j];
                        students[0][2] += 1;
                    }
                    else if (scores[i][j] == 1) {
                        students[0][0] += scores[i][j];
                        students[0][1] += 1;
                    }
                }
                else if (j == 1) {
                    if (scores[i][j] == 3) {
                        students[1][0] += scores[i][j];
                        students[1][3] += 1;
                    }
                    else if (scores[i][j] == 2) {
                        students[1][0] += scores[i][j];
                        students[1][2] += 1;
                    }
                    else if (scores[i][j] == 1) {
                        students[1][0] += scores[i][j];
                        students[1][1] += 1;
                    }
                }
                else if (j == 2) {
                    if (scores[i][j] == 3) {
                        students[2][0] += scores[i][j];
                        students[2][3] += 1;
                    }
                    else if (scores[i][j] == 2) {
                        students[2][0] += scores[i][j];
                        students[2][2] += 1;
                    }
                    else if (scores[i][j] == 1) {
                        students[2][0] += scores[i][j];
                        students[2][1] += 1;
                    }
                }
            }
        }

        int max = students[0][0];
        int max3 = students[0][3];
        int max2 = students[0][2];
        int maxStudent = 1;

        boolean flag = true;

        for (int i = 1; i < 3; i++) {

            if (max < students[i][0]) {
                max = students[i][0];
                max3 = students[i][3];
                max2 = students[i][2];
                maxStudent = i + 1;
                flag = true;
            }
            else if (max == students[i][0]) {
                if (max3 < students[i][3]) {
                    max = students[i][0];
                    max3 = students[i][3];
                    max2 = students[i][2];
                    maxStudent = i + 1;
                    flag = true;
                }
                else if (max3 == students[i][3]) {
                    if (max2 < students[i][2]) {
                        max = students[i][0];
                        max3 = students[i][3];
                        max2 = students[i][2];
                        maxStudent = i + 1;
                        flag = true;
                    }
                    else if (max2 == students[i][2]) {
                        flag = false;
                        max = students[i][0];
                        max3 = students[i][3];
                        max2 = students[i][2];
                        maxStudent = i + 1;
                    }
                }
            }
        }
        if (flag == false) bw.write("0 " + max + "\n");
        else bw.write(maxStudent+" "+max+"\n");
        bw.flush();
        bw.close();

    }

}