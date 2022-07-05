package programmers.programmersTargetNumber;

class Solution {
    int methodNumbers = 0;
    public int solution(int[] numbers, int target) {

        dfs(0, numbers, 0, numbers.length, target);
        return methodNumbers;
    }

    public void dfs(int curleaf, int[] numbers, int cnt, int length, int target){
        if(curleaf + 1 == length){
            if(cnt + numbers[curleaf] == target || cnt - numbers[curleaf] == target)
                methodNumbers++;

            return;
        }

        dfs(curleaf + 1, numbers, cnt + numbers[curleaf], length, target);
        dfs(curleaf + 1, numbers, cnt - numbers[curleaf], length, target);
        return;
    }
}