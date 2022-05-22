class Solution {
    public int solution(int[][] triangle) {
        int answer = dp(triangle, triangle.length-1);
        return answer;
    }

    public int dp(int[][] t, int index){
        int a, b;
        if(index == 0){
            return t[0][0];
        }

        for(int i=0; i<index; i++){
            a = t[index][i] + t[index-1][i];
            b = t[index][i+1] + t[index-1][i];
            t[index-1][i] = (a > b) ? a : b;
        }

        return dp(t, index-1);
    }
}