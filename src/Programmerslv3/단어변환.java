package Programmerslv3;

public class 단어변환 {
    static boolean[] visited;
    static int answer = 1000;
    public int solution(String begin, String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if(compare(begin,words[i])<=1){
                visited = new boolean[words.length];
                visited[i] = true;
                dfs(1, i, target, words);
            }
        }
        return answer == 1000 ? 0 : answer;
    }
    public static void dfs(int cnt, int cur, String target, String[] words){
        if(target.equals(words[cur])){
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(!visited[i] && compare(words[cur], words[i]) == 1){
                visited[i] = true;
                dfs(cnt+1, i, target, words);
                visited[i] = false;
            }
        }
    }
    public static int compare(String a, String b){
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        단어변환 a = new 단어변환();
        String[] words = {"hot", "dot", "dog","lot","log","cog"};
        System.out.println(a.solution("hit","cog",words));
    }
}
