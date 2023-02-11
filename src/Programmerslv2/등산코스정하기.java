package Programmerslv2;

import java.util.*;

public class 등산코스정하기 {

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        int[][] costs = new int[n+1][n+1];
        HashSet gate = new HashSet(); HashSet summit = new HashSet();
        for (int i = 0; i < gates.length; i++) {
            gate.add(gates[i]);
        }
        for (int i = 0; i < summits.length; i++) {
            summit.add(summits[i]);
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {
            list.get(paths[i][0]).add(paths[i][1]);
            list.get(paths[i][1]).add(paths[i][0]);
            costs[paths[i][0]][paths[i][1]] = paths[i][2];
            costs[paths[i][1]][paths[i][0]] = paths[i][2];
        }
        for (int i = 0; i < gates.length; i++) {
            boolean[] visited = new boolean[n+1];
            visited[gates[i]] = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] paths = {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        int[] gates = {1,3}; int[] summits = {5};
        등산코스정하기 a = new 등산코스정하기();
        System.out.println(Arrays.toString(a.solution(6,paths,gates,summits)));


    }
}
