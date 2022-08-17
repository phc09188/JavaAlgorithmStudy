package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj2862 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        int p1 = 1; int p2 = 1;
        for (int i = 1; i < N+1; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num%2 == 0){
                visited[i] = true;
            }
        }
        int count = 0; int max = 0;
        while(p2 <= N){
            if(count<K){
                if(!visited[p2]) count++;
                p2++;
                max = Math.max(max, p2-p1-count);
            }else if(visited[p2]){
                p2++;
                max = Math.max(max, p2-p1-count);
            }else if(count == K && !visited[p2]){
                if(!visited[p1]) count--;
                p1++;
            }
        }
        System.out.println(max);
    }
}
