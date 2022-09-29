package Programmers_CodeTest;

import BAEKJOON.boj2206;

import java.util.*;

public class twelfthTeset {
    static String a;
    static int cnt =0;
    public static int solution1(String s){
        while(!s.equals("a")) {
            boolean[] visited = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if(!visited[i] &&s.charAt(i) =='a'){
                    if(i+1 <s.length()&&s.charAt(i+1) == 'a'){
                        visited[i] = true;
                        for (int j = i+1; j < s.length(); j++) {
                            visited[j] = true;
                            if(j == s.length()-1 && s.charAt(j) == 'a'){
                                s = s.substring(0,i) + 'a';
                                break;
                            }
                            if(s.charAt(j) != s.charAt(i+1)){
                                s = s.substring(0,i) +'a' + s.substring(j);
                                visited = new boolean[s.length()];
                                visited[0] = true;
                                break;
                            }
                        }
                    }else if(i>0&& i<s.length()-1){
                        char[] arr = s.toCharArray();
                        arr[i-1] = 'a'; arr[i+1] = 'a';
                        visited[i-1] = true; visited[i] = true; visited[i+1] = true;
                        String w = "";
                        for (int j = 0; j < s.length(); j++) {
                            w += arr[j];
                        }
                        s = w;
                    }else if(i>0){
                        char[] arr = s.toCharArray();
                        arr[i-1] ='a';
                        visited[i-1] = true; visited[i] = true;
                        String w = "";
                        for (int j = 0; j < s.length(); j++) {
                            w += arr[j];
                        }
                        s = w;
                    }else{
                        char[] arr = s.toCharArray();
                        arr[i+1] = 'a';
                        visited[i] = true; visited[i+1] = true;
                        String w = "";
                        for (int j = 0; j < s.length(); j++) {
                            w += arr[j];
                        }
                        s = w;
                    }

                }
            }
            cnt++;
        }
        return cnt;
    }
    public static int solution2(int[] heights) {
        int answer= 0;
        int max =0;
        for (int i = 0; i < heights.length; i++) {
            if(heights[i]>max){
                max = heights[i];
            }
        }
        for (int i = 1; i <= max; i++) {
            int start = 0;
            for (int j = 0; j < heights.length; j++) {
                if(j == heights.length-1){
                    answer = Math.max(answer, (j-start)*i);
                }
                if(heights[j] >=i){
                    continue;
                }else{
                    if(start ==0){
                        answer = Math.max(answer,(j-start) * i);
                    }else{
                        answer = Math.max(answer,(j-start-1) * i);
                    }
                    if(j ==0){
                        start = 1;
                    }else {
                        start = j;
                    }
                }
            }
        }
        return answer;
    }
    public static int solution3(int[] status) {
        int answer = 0;

        return answer;
    }
    public static int[] solution4(int[] arr, int k) {
        if(k== arr.length){
            return arr;
        }
        int[] answer = new int[arr.length-k+1];
        for (int i = 0; i <= arr.length-k; i++) {
            int a = findMid(arr,k, i);
            answer[i] = a;
        }
        return answer;
    }
    public static int findMid(int[] arr, int k, int startidx){
        int[] a = new int[k];
        int cnt = 0;
        for (int i = startidx; i < startidx+k; i++) {
            a[cnt++] = arr[i];
        }
        Arrays.sort(a);
        return arr[k/2];
    }
    static class Loc{
        int i;
        int j;
        int cnt;
        boolean destroyed;

        public Loc(int i, int j, int cnt, boolean d) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
            this.destroyed = d;
        }
    }
    public static int solution5(int N, int M, int[][] maze) {
        Queue<Loc> q = new LinkedList<>();
        q.add(new Loc(0, 0, 0, false));

        int[] mi = {0, 0, -1, 1};
        int[] mj = {-1, 1, 0, 0};

        boolean[][][] visited = new boolean[N][M][2];

        while (!q.isEmpty()) {
            Loc now = q.poll();

            if (now.i == N - 1 && now.j == M - 1) {
                return now.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int ni = now.i + mi[d];
                int nj = now.j + mj[d];

                if(ni<0 || ni>=N || nj<0 || nj>=M) continue;

                int next_cnt = now.cnt+1;

                if(maze[ni][nj]==0){
                    if(!now.destroyed && !visited[ni][nj][0]) {
                        q.add(new Loc(ni, nj, next_cnt, false));
                        visited[ni][nj][0] = true;
                    }else if(now.destroyed && !visited[ni][nj][1]){
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                }else if(maze[ni][nj]==1){
                    if(!now.destroyed){
                        q.add(new Loc(ni, nj, next_cnt, true));
                        visited[ni][nj][1] = true;
                    }
                }
            }

        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println(solution1("iiaiiioaaiiaaaiipp"));
//        int[] heights = {3,4,5,6,5,4,3,2,1};
//        System.out.println(solution2(heights));
//        int[] status = {1,1,0,1,0,1};
//        System.out.println(solution3(status));
//        int[] arr = {4,2,6,3,2,4,3};
//        System.out.println(solution4(arr, 3));
//        int[][] maze = {
//                {0,0,0,0,0,0},
//                {0,1,1,1,1,0},
//                {0,1,0,0,0,0},
//                {1,1,0,1,0,1},
//                {0,0,0,0,1,0},
//                {1,1,1,0,0,0}
//        };
//        System.out.println(solution5(6,6,maze));
    }
}
