package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {
    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    static int V,E, K;
    static int[] df;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        df = new int[V+1];
        Arrays.fill(df,INF);
        for (int i = 0; i < V+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.get(cur).add(new Node(to,weight));
        }
        dijkstra(K);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=V; i++) {
            if (df[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else {
                sb.append(df[i]+"\n");
            }
        }
        System.out.println(sb.toString());
    }
    static void dijkstra(int start) {
        // 1. 출발지 비용은 0으로 하고 출발지를 PQ에 넣고 시작
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        df[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if (now.weight > df[now.to]) continue;

            int len = list.get(now.to).size();
            for (int i = 0; i<len; i++) {
                Node next = list.get(now.to).get(i);

                if (df[next.to] > now.weight + next.weight ) {
                    df[next.to] = now.weight + next.weight;
                    pq.add(new Node(next.to, df[next.to]));
                }
            }

        }
    }
}
