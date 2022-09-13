package BAEKJOON;

import java.io.*;
public class boj10026 {
    static class Point {
        int x;
        int y;
        char c;

        public Point(int x, int y, char c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int normal = 0; int sick = 0;
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if(arr[j] == 'R'){
                    map[i][j] = 1;
                }else if(arr[j] == 'G'){
                    map[i][j] = 2;
                }else{
                    map[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 1; k < 4; k++) {
                    if(!visited[i][j]  && map[i][j] == k){
                        dfs(i,j,k);
                        normal++;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1){
                    map[i][j] =2;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 2; k < 4; k++) {
                    if(!visited[i][j]  && map[i][j] == k){
                        dfs(i,j,k);
                        sick++;
                    }
                }
            }
        }
        System.out.println(normal + " "+ sick);
    }

    public static void dfs(int x, int y, int type){
        visited[x][y] = true;
        for(int[] dir: dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx>=0&&nx<N&&ny>=0&&ny<N && !visited[nx][ny]) {
                if(map[nx][ny] == type){
                    dfs(nx,ny, type);
                }
            }
        }
    }
}