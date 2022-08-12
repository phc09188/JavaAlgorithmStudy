package BAEKJOON;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class tomato{
    int x;
    int y;
    tomato(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class boj7576 {
    final static int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    static int[][] box;
    public static void main(String[] args )throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        box = new int[M][N];
        Queue<tomato> qu = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1) qu.offer(new tomato(i,j));
            }
        }
        while(!qu.isEmpty()){
            tomato t = qu.poll();
            for(int[] dir : dirs){
                int x = t.x + dir[0];
                int y =  t.y + dir[1];
                if(x>= 0&&y>=0&&x< box.length&&y<box[0].length){
                    if(box[x][y] == 0){
                        qu.offer(new tomato(x,y));
                        box[x][y] = box[t.x][t.y] + 1;
                    }
                }
            }
        }
        int date = 0;
        for (int i = 0; i < M; i++) {
            if(date == -1) break;
            for (int j = 0; j < N; j++) {
                if(box[i][j] ==0){
                    date = -1;
                    break;
                }
                date = Math.max(date, box[i][j]);
            }
        }
        if(date ==1) System.out.println(0);
        else if(date ==-1) System.out.println(-1);
        else System.out.println(date -1);
    }
}
