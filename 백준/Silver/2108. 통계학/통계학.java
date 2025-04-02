import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            list.add(k);
        }

        Collections.sort(list);

        int a = 0;

        for (int i = 0; i < N; i++) {
            a += list.get(i);
        }

        a = (int)Math.round((double)a / N);

        int b = list.get(N / 2);

        sb.append(a).append("\n");
        sb.append(b).append("\n");

        HashMap<Integer, Integer> freqMap = new HashMap<>();


        for (int num : list) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;

        List<Integer> modeCandidates = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                modeCandidates.clear();
                modeCandidates.add(num);
            }
            else if (freq == maxFreq) {
                modeCandidates.add(num);
            }
        }

        Collections.sort(modeCandidates);
        int mode = modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0);

        sb.append(mode).append("\n");

        int max = list.get(0);
        int min = list.get(0);

        for (int i = 1; i < N; i++) {
            if (max < list.get(i)) max = list.get(i);
            if (min > list.get(i)) min = list.get(i);
        }

        sb.append(max - min).append("\n");

        System.out.println(sb);

    }

}