package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class pos{
    int to;
    int dist;
    public pos(int to, int dist){
        this.to = to;
        this.dist = dist;
    }
}
public class boj10282 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while(k --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ArrayList<pos>[] edge = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) {
                edge[i] = new ArrayList<>();
            }
            while(d-->0){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                edge[b].add(new pos(a,s));
            }
            int[] res = dijkstra(n, c, edge);
            int cnt = 0; int max = 0;
            for (int i = 1; i <= n; i++) {
                if(res[i] == Integer.MAX_VALUE) continue;
                cnt++;
                if(max < res[i]){
                    max = res[i];
                }
            }
            System.out.println(cnt + " " + max);
        }
    }
    public static int[] dijkstra(int n, int c, ArrayList<pos>[] edge){
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<Integer> pq = new PriorityQueue();
        pq.add(c);
        res[c] = 0;
        while(!pq.isEmpty()){
            int cur = pq.poll();
            for(pos pos : edge[cur]){
                int next = pos.to;
                if(res[next] > res[cur]+ pos.dist){
                    res[next] = res[cur] + pos.dist;
                    pq.add(next);
                }
            }
        }
        return res;
    }
}
