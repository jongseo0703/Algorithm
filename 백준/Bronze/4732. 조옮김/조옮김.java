import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        String[] music = {"A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#"};
        Map<String, Integer> noteToIndex = new HashMap<>();
        for (int i = 0; i < music.length; i++) {
            noteToIndex.put(music[i], i);
        }

        while (true) {
            String line = br.readLine();
            if (line.equals("***")) break;

            st = new StringTokenizer(line);
            int count = st.countTokens();
            String[] arr = new String[count];

            for (int i = 0; i < count; i++) {
                arr[i] = st.nextToken();
            }

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < arr.length; i++) {
                
                if (arr[i].equals("Bb")) arr[i] = "A#";
                else if (arr[i].equals("Db")) arr[i] = "C#";
                else if (arr[i].equals("Eb")) arr[i] = "D#";
                else if (arr[i].equals("Gb")) arr[i] = "F#";
                else if (arr[i].equals("Ab")) arr[i] = "G#";
                else if (arr[i].equals("Cb")) arr[i] = "B";
                else if (arr[i].equals("Fb")) arr[i] = "E";
                else if (arr[i].equals("E#")) arr[i] = "F";
                else if (arr[i].equals("B#")) arr[i] = "C";

                int currentIndex = noteToIndex.get(arr[i]);

                int newIndex = (currentIndex + n) % music.length;
                if (newIndex < 0) {
                    newIndex += music.length;
                }

                arr[i] = music[newIndex];
            }

            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}