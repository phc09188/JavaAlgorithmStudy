package codeTest;

import java.io.*;
import java.util.*;

public class boj1260 {
    static int[][] node = new int[1001][1001];
    static boolean[] visited = new boolean[1001];
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int cur = Integer.parseInt(st.nextToken());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }
        dfs(cur);
        Arrays.fill(visited, false);
        System.out.println("");
        bfs(cur);
    }
    static void dfs(int x){
        if(visited[x]) return;
        visited[x] = true;
        System.out.print(x+" ");
        for (int i = 1; i < node.length; i++) {
            if(node[x][i] == 1){
                dfs(i);
            }
        }
    }
    static void bfs(int x){
        Queue<Integer> qu = new LinkedList();
        qu.offer(x);
        visited[x] =true;
        while(!qu.isEmpty()){
            x = qu.poll();
            System.out.print(x+" ");
            for (int i = 1; i < node.length; i++) {
                if(!visited[i] && node[x][i] == 1 ){
                    qu.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
