import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = bfs(begin, target, words);
        
        return answer;
    }
    
    static int bfs(String begin, String target, String[] words) {
        Queue<String[]> queue = new LinkedList<>();
        queue.add(new String[]{begin, "0"});
        boolean[] isVisited = new boolean[words.length];
        
        int count = 0;
        
        while(!queue.isEmpty()) {
            String[] now = queue.poll();
            String curWord = now[0];
            int curCount = Integer.parseInt(now[1]);
            
            if(curWord.equals(target)) {
                return curCount;
            }
            
            String[] alpha = new String[begin.length()];
            
            for(int i = 0; i < alpha.length; i++) {
                alpha[i] = curWord.charAt(i) + "";
            }
            
            for(int i = 0; i < words.length; i++) {
                if(!isVisited[i]) {
                    int cnt = 0;

                    String[] nextAlpha = new String[words[i].length()];
                    for(int j = 0; j < words[i].length(); j++) {
                        nextAlpha[j] = words[i].charAt(j) + "";
                    }

                    for(int j = 0; j < words[i].length(); j++) {
                        if(nextAlpha[j].equals(alpha[j])) {
                            cnt++;
                        }
                    }

                    if(cnt == curWord.length() - 1) {
                        queue.add(new String[]{words[i], String.valueOf(curCount + 1)});
                        isVisited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}