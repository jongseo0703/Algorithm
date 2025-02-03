import java.io.*;

class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int n = s.length();

        int r = 0;
        for(int i = 1;i <= Math.sqrt(n); i++) {

            if(n % i == 0) {
                r = Math.max(r, i);
            }
        }
        int c = n / r;

        char[][] msg = new char[r][c];
        int idx = 0;
        for(int j = 0; j < c; j++) {
            for(int i=0; i < r; i++) {
                msg[i][j] = s.charAt(idx++);
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                
                sb.append(msg[i][j]);
                
            }
        }
        
        System.out.println(sb);
        
    }

}