package BAEKJOON;

import java.io.*;
import java.util.*;

class xy implements Comparable<xy>{
    int x;
    int y;
    public xy(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(xy o) {
        if(this.y> o.y){
            return 1;
        }else if(this.y == o.y){
            if(this.x > o.x){
                return 1;
            }
        }
        return -1;
    }
}
public class boj11651 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<xy> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new xy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        while(!pq.isEmpty()){
            xy a = pq.poll();
            System.out.println(a.x + " " + a.y);
        }
    }
}
