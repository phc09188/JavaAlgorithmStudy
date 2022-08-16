package Programmerslv3;

import java.util.*;
public class 섬연결하기 {
    static int[] parent;
    public static int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (int[] c1, int[] c2) -> c1[2] -c2[2]);
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for(int[] edge : costs){
            int from = edge[0]; int to = edge[1]; int cost = edge[2];
            int fromparent = findparent(from);
            int toparent = findparent(to);
            if(fromparent == toparent) continue;
            answer += cost;
            parent[toparent] = fromparent;
        }
        return answer;
    }
    //Kruskal Algorithm
    private static int findparent(int node){
        if(parent[node] == node) return node;
        return parent[node] = findparent(parent[node]);
    }
    public static void main(String[] args){
        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1},{2,3,8}};
        System.out.println(solution(4,costs));
    }
}
