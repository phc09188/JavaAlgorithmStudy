package BAEKJOON;

import java.util.*;
import java.io.*;
public class boj2638 {
    static int[][] map;
    static int N, M;
    static ArrayList<Node> cheese_melt;
    static boolean[][] visited;
    static int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    static class Node{
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        cheese_melt = new ArrayList<>();
        while(true){
            cheese_melt.clear();
            visited = new boolean[N][M];
            setExternalAir();
            for (int i = 1; i <N-1; i++) {
                for (int j = 1; j < M-1; j++) {
                    if(map[i][j] ==1){
                        if(isMelted(i,j)){
                            cheese_melt.add(new Node(i,j));
                        }
                    }
                }
            }
            if(cheese_melt.size() ==0) break;
            for(Node x : cheese_melt){
                map[x.i][x.j] = 0;
            }
            time++;
        }
        System.out.println(time);

    }
    private static boolean isMelted(int i, int j){
        int cnt = 0;
        for(int[] dir : dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni<0 || nj<0 || ni>=N || nj>=M)continue;
            if(map[ni][nj] == -1) cnt++;
        }
        return cnt >=2;
    }

    private static void setExternalAir() {
        Queue<Node> qu = new LinkedList<>();
        qu.add(new Node(0,0));
        map[0][0] = -1;
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            for(int[] dir : dirs){
                int ni = cur.i + dir[0];
                int nj = cur.j + dir[1];
                if(ni<0 || nj<0 || ni>=N || nj>=M)continue;
                if(visited[ni][nj] || map[ni][nj] == 1) continue;
                visited[ni][nj] = true;
                map[ni][nj] = -1;
                qu.add(new Node(ni,nj));
            }
        }
    }
}
