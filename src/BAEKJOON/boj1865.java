package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.StringTokenizer;

public class boj1865 {
    static class Node  {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc -->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken()); int W = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for (int i = 0; i < N+1; i++) {
                list.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken()); int w = Integer.parseInt(st.nextToken());
                list.get(e).add(new Node(s,w));
                list.get(s).add(new Node(e,w));
            }
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken()); int e = Integer.parseInt(st.nextToken()); int w = Integer.parseInt(st.nextToken());
                list.get(s).add(new Node(e,-w));
            }
            boolean minus = false;
            for (int i = 1; i <= N; i++) {
                if(solution(i,N)){
                    minus = true;
                    sb.append("YES\n");
                    break;
                }
            }
            if(!minus){
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static boolean solution(int i, int n ){
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        dist[i] = 0;
        boolean update = false;
        for (int t = 1; t <=n ; t++) {
            update = false;
            for (int j = 1; j <= n; j++) {
                for (Node node : list.get(j)) {
                    if (dist[j] != INF && dist[node.to] > dist[j] + node.weight) {
                        dist[node.to] = dist[j] + node.weight;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }
        return update;
    }
}
