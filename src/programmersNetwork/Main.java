package programmersNetwork;

class Solution {
    boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];

        for(int i=0; i<computers.length; i++){
            if(visited[i] == false){
                visited[i] = true;
                answer++;
                dfs(i, computers);
            }
        }
        return answer;
    }

    public void dfs(int curNode, int[][] computers){
        for(int i=0; i<computers.length; i++){
            if(curNode == i)
                continue;

            if(computers[curNode][i] == 1 && visited[i] == false){
                visited[i] = true;
                dfs(i, computers);
            }
        }
        return;
    }
}