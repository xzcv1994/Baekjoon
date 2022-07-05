package programmers.programmersChangeWord;

class Solution {
    static int min=Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        int wordsSize = words.length;

        boolean[] relation1 = new boolean[wordsSize+1];
        boolean[][] relation2 = new boolean[wordsSize+1][wordsSize+1];
        boolean[] visited = new boolean[wordsSize+1];

        for(int i=0; i<wordsSize; i++){//이거를 시작단어 만큼 반복으로 해놨었네 이런  words배열 만큼 반복하게 했어야지 바보야
            int cnt = 0;
            for(int j=0; j<begin.length(); j++){
                if(begin.charAt(j) != words[i].charAt(j))
                    cnt++;
            }
            if(cnt == 1)
                relation1[i] = true;
        }

        for(int i=0; i<wordsSize; i++)
            compare(words[i], words, relation2, i);

        for(int i=0; i<wordsSize; i++){
            if(relation1[i] == true){
                visited[i] = true;
                dfs(words, relation2, i, visited, target, 1);
                visited[i] = false;
            }
        }

        return min != Integer.MAX_VALUE ? min : 0;
    }

    public void compare(String target, String[] words, boolean[][] relation, int targetIndex){
        for(int i=0; i<words.length; i++){
            int cnt = 0;
            if(targetIndex == i)
                continue;

            for(int j=0; j<target.length(); j++){
                if(target.charAt(j) != words[i].charAt(j))//이부분 실수함 같은거 만큼 증가하게 해놓고 밑에서 같은 갯수가 2인것을 관계짓게함 단어길이가 3이상인 경우를 생각안한 바보 같은 케이스
                    cnt++;
            }

            if(cnt == 1){//이부분 실수함
                relation[targetIndex][i] = true;
                relation[i][targetIndex] = true;
            }
        }
    }

    public void dfs(String[] words, boolean[][] relation, int index, boolean[] visited, String target, int cnt){
        if(target.equals(words[index])){
            min = (cnt < min ? cnt : min);
            return;
        }

        for(int i=0; i<words.length; i++){
            if(index == i)
                continue;

            if(relation[index][i] == true && visited[i] == false){
                visited[i] = true;
                dfs(words, relation, i, visited, target, cnt+1);
                visited[i] = false;
            }
        }
        return;
    }
}