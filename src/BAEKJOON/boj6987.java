package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj6987 {
    static class Node{
        int x;
        int y;
        int mirror;
        int cnt;

        public Node(int x, int y, int mirror, int cnt) {
            this.x = x;
            this.y = y;
            this.mirror = mirror;
            this.cnt = cnt;
        }
    }
    static Node start, end;
    static int N,M;
    static String[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        arr = new String[M][N];
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = input[j];
                if(arr[i][j].equals("C")){
                    if(start == null) start = new Node(i,j,-1,0);
                    else end = new Node(i,j,-1,0);
                }
            }
        }
        bfs();
        System.out.println(min);
    }
    public static void bfs(){
        Queue<Node> qu = new LinkedList<>();
        qu.add(start);
        visited = new int[M][N];
        visited[start.x][start.y] = 1;
        while(!qu.isEmpty()){
            Node cur = qu.poll();
            int x = cur.x; int y = cur.y; int mirror = cur.mirror; int cnt = cur.cnt;
            if(x == end.x && y==end.y){
                min = Math.min(min, cur.cnt);
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i]; int ny = y+dy[i]; int ni = i;
                if(nx <0 ||nx >=M || ny<0 || ny>=N || arr[nx][ny].equals("*")) continue;
                int nm = cnt;
                if(mirror != -1 && mirror != ni){
                    nm++;
                }
                if(visited[nx][ny] == 0){
                    visited[nx][ny] = nm; qu.add(new Node(nx,ny, ni, nm));
                }else if(visited[nx][ny] >= nm){
                    visited[nx][ny] = nm; qu.add(new Node(nx,ny,ni,nm));
                }
            }
        }
    }
}
