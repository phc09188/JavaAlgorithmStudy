package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1613 {
    static int N, K,S;
    static int[][] dist;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  K = Integer.parseInt(st.nextToken());
        dist = new int[N+1][N+1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dist[start][end] = -1; dist[end][start] = 1;
        }
        floyd_warshall();
        S = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dist[start][end] + "\n");
        }
        System.out.println(sb.toString());
    }
    public static void floyd_warshall(){
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <=N; j++) {
                    if(dist[i][k] ==0){
                        if(dist[i][k] ==1 && dist[k][j] ==1){
                            dist[i][j] = 1;
                        }else if(dist[i][k] == -1 && dist[k][j] ==-1){
                            dist[i][j] =-1;
                        }
                    }
                }
            }
        }
    }
}
