package Programmerslv2;

import java.util.*;
class Ro implements Comparable<Ro>{
    int next;
    int time;
    public Ro(int next, int time){
        this.next = next;
        this.time = time;
    }

    @Override
    public int compareTo(Ro o) {
        return this.time - o.time;
    }
}
public class 배달 {
    static List<Ro>[] list;
    static int[] distance;
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        list = new ArrayList[N+1];
        distance = new int[N+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int i = 0; i < road.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            list[road[i][0]].add(new Ro(road[i][1], road[i][2]));
            list[road[i][1]].add(new Ro(road[i][0], road[i][2]));
        }
        dijkstra();
        for (int i = 0; i < distance.length; i++) {
            if(distance[i] <=K){
                answer++;
            }
        }
        return answer;
    }
    public static void dijkstra(){
        PriorityQueue<Ro> pq = new PriorityQueue<>();
        pq.add(new Ro(1,0));
        while(!pq.isEmpty()){
            Ro a = pq.poll();
            int next = a.next;
            int time = a.time;
            if(distance[next] < time){
                continue;
            }
            for (int i = 0; i < list[next].size(); i++) {
                int next2 = list[next].get(i).next;
                int time2 = list[next].get(i).time + time;
                if(distance[next2] > time2){
                    distance[next2] = time2;
                    pq.add(new Ro(next2, time2));
                }
            }
        }
    }
    public static void main(String[] args){
        int[][] road = {{1,2,1}, {2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(solution(5,road,3));
    }
}
