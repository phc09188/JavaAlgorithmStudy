package codeTest;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class virus{
    int x;
    int y;
    public virus(int x, int y ){
        this.x = x;
        this.y = y;
    }
}
public class boj14502 {
    static int n;
    static int m;
    static int[][] a = new int[10][10];
    static int[][] b = new int[10][10];
    static int[][] dirs = {{-1,0},{1,0}, {0,1},{0,-1}};
    public static void dfs(int x, int y){
        for(int[] dir : dirs){
            int nx = x + dir[0];
            int ny = y + dir[1];
            if(nx>=0 &&ny>=0&& nx<n&&ny<m){
                if(b[nx][ny] ==0){
                    b[nx][ny] =2;
                    dfs(nx,ny);
                }
            }
        }
    }
    public static int dfs(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i,j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(b[i][j] ==0) cnt++;
            }
        }
        return cnt;
    }
    public static int bfs() {
        Queue<virus> qu = new LinkedList<>();
        b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = a[i][j];
                if(a[i][j] ==2){
                    qu.add(new virus(i,j));
                }
            }
        }
        while(!qu.isEmpty()){
            virus q = qu.poll();
            int x = q.x;
            int y = q.y;
            for(int[] dir : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx>=0 &&ny>=0&& nx<n&&ny<m){
                    if(b[nx][ny] == 0){
                        b[nx][ny] = 2;
                        qu.add(new virus(nx,ny));
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(b[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int x1 = 0; x1 < n; x1++) {
            for (int y1 = 0; y1 < m; y1++) {
                if(a[x1][y1] != 0) continue;
                for (int x2 = 0; x2 < n; x2++) {
                    for (int y2 = 0; y2 < m; y2++) {
                        if(a[x2][y2] != 0) continue;
                        for (int x3 = 0; x3 < n; x3++) {
                            for (int y3 = 0; y3 < m; y3++) {
                                if(a[x3][y3] != 0) continue;
                                if(x1 == x2 && y1 == y2) continue;
                                if(x1 == x3 && y1 == y3) continue;
                                if(x2 == x3 && y2 == y3) continue;
                                a[x1][y1] = 1; a[x2][y2] = 1; a[x3][y3] = 1;
                                int cur = bfs();
                                result = Math.max(result, cur);
                                a[x1][y1] = 0; a[x2][y2] = 0; a[x3][y3] = 0;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
