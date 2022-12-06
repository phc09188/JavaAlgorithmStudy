package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1167 {
    static class Edge{
        int v;
        int weight;

        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
    }
    public static int V, answer, maxVertex;
    public static boolean[] visited;
    public static List<Edge>[] edgeLists;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        edgeLists = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            edgeLists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1){
                    break;
                }
                int weight = Integer.parseInt(st.nextToken());
                edgeLists[from].add(new Edge(to,weight));
            }
        }
        visited = new boolean[V+1];
        go(1,0);
        visited = new boolean[V+1];
        go(maxVertex, 0);

        System.out.println(answer);
    }

    private static void go(int v, int w) {
        if(answer < w){
            answer = w;
            maxVertex = v;
        }
        visited[v] = true;
        for (Edge e : edgeLists[v]){
            if(!visited[e.v]){
                go(e.v,e.weight+w);
            }
        }
    }

}
