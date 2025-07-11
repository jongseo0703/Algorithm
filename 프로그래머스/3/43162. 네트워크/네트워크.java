class Solution {
    static boolean[] isVisited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        isVisited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void dfs(int start, int n, int[][] computers) {
        isVisited[start] = true;
        
        for(int i = 0; i < n; i++) {
            if(computers[start][i] == 1 && !isVisited[i]) {
                dfs(i, n, computers);
            }
        }
    }
}