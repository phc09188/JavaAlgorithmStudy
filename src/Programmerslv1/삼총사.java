package Programmerslv1;

public class 삼총사 {
    static int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        combination(number,visited,0,number.length,3);
        return answer;
    }
    void combination(int[] arr, boolean[] visited, int depth, int n, int r){
        if(r == 0){
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    cnt += arr[i];
                }
            }
            if(cnt ==0) answer++;
            return;
        }
        if(depth ==n){
            return;
        }
        visited[depth] = true;
        combination(arr, visited, depth+1, n, r-1);
        visited[depth] = false;
        combination(arr, visited, depth+1, n, r);
    }
}
