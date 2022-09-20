package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1238 {
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

    static int N, M, X;
    static List<List<Node>> list, reverseList;
    static int[] dist, reverseDist;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        dist = new int[N + 1];
        reverseDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            max = Math.max(max, dist[i]+reverseDist[i]);
        }

        dist = new int[N + 1];
        reverseDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(u).add(new Node(v, weight));
            reverseList.get(v).add(new Node(u, weight));
        }

        dijkstra(list, dist, X);
        dijkstra(reverseList, reverseDist, X);

        int ans = -1;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i] + reverseDist[i]);
        }
        System.out.println(ans);
    }
    private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        distance[start] = 0;

        while (!pq.isEmpty()) {
            int idx = pq.poll().to;

            if (visited[idx]) continue;
            visited[idx] = true;

            for (Node node : list.get(idx)) {
                if (distance[node.to] > distance[idx] + node.to) {
                    distance[node.to] = distance[idx] + node.to;
                    pq.add(new Node(node.to, distance[node.to]));
                }
            }
        }
    }
}
