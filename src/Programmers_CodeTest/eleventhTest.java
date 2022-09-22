package Programmers_CodeTest;

import java.util.*;

public class eleventhTest {
    public static int solution1(int n, int num) {
        String input = "" + num;
        while(n --> 0){
            String result ="";
            int[] arr = new int[10];
            for (int i = 0; i < input.length(); i++) {
                int a = input.charAt(i)-48;
                arr[a] += 1;
            }
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] != 0){
                    result += i;
                    result += arr[i];
                }
            }
            input = result;
        }

        return (int)(Long.parseLong(input) %10004);
    }
    public static int[] solution2(int n) {
        String[] arr = new String[n];
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            arr[i-1] = String.valueOf(i);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) == o2.charAt(0)){
                    return o1.compareTo(o2);
                }
                return o1.charAt(0) > o2.charAt(0) ? 1 : -1;
            }
        });
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(arr[i]);
        }
        return answer;
    }
    /*static int answer = Integer.MAX_VALUE;
    static int n, m;
    public static int solution(int money, int[] chips) {
        Arrays.sort(chips);
        n = chips.length;  m = money;
        DFS(0,0,chips);
        return answer;
    }
    public static void DFS(int L, int sum, int[] arr) {
        if (sum > m) return;
        if (L >= answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }*/
    public static boolean solution(String s, String[] words) {
        boolean[] visited = new boolean[s.length()];
        for(String word : words){
            if(s.contains(word)){
                for (int j = 0; j < word.length(); j++) {
                    for (int i = 0; i < s.length(); i++){
                        if(s.charAt(i) == word.charAt(j) && i+word.length() <= s.length()){
                            if(s.substring(i, i+word.length()).equals(word)){
                                for (int k = i; k < i+word.length(); k++) {
                                    visited[k] = true;
                                }
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }
        boolean answer = true;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                answer = false;
                break;
            }
        }
        return answer;
    }


    static int[] dp;
    public static int solution4(int money, int[] chips) {
        Arrays.sort(chips);
        dp = new int[money+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        return knapsack(chips, money);
    }
    static int knapsack(int[] chips, int m) {
        for (int chip : chips) {
            for (int j = chip; j <= m; j++) {
                int tmp = dp[j - chip] + 1;
                if (dp[j] > tmp) dp[j] = tmp;
            }
        }
        return dp[m];
    }
    static int[][] dirs = {{0,1}, {0,-1},{1,0},{-1,0}};
    static class Node{
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public static int solution5(int N, int M, int[][] maze) {
        boolean[][] visited = new boolean[N][M];
        visited[0][0]= true;
        int cnt = 0;
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(0,0,0));
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            if(cur.x == N-1 && cur.y == M-1){
                cnt = cur.cnt;
                break;
            }
            for(int[] dir : dirs){
                int x = cur.x + dir[0]; int y = cur.y + dir[1];
                if(x>=0 && y>=0 && x<=N-1 && y<=M-1){
                    if(!visited[x][y] && maze[x][y] ==0){
                        visited[x][y] = true;
                        qu.add(new Node(x,y,cur.cnt+1));
                    }
                }
            }
        }
        return cnt;
    }
    public static void main (String[] args){
        String[] words = {"zer","ro","ze","base"};
        System.out.println(solution("zerobase", words));
    }
}
