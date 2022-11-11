package BAEKJOON;
import java.util.*;
import java.io.*;

class Main{

    static int N;
    static PriorityQueue<Edge> q = new PriorityQueue<>();
    static int total = 0;
    static int[] parent;
    static int usedLan = 0;

    static class Edge implements Comparable<Edge>{
        int v1;
        int v2;
        int weight;

        Edge(int v1, int v2, int weight){
            this.v1=v1;
            this.v2=v2;
            this.weight = weight;
        }

        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static int MST(){

        parent = new int[N+1];

        for(int i=0; i<=N; i++){
            parent[i] = i;
        }

        int count = 0;

        while(!q.isEmpty()){
            if(count==N-1) break;

            Edge now = q.poll();
            if(find(now.v1)!=find(now.v2)){
                usedLan += now.weight;
                union(now.v1, now.v2);
                count++;
            }
        }

        return count<N-1?-1:total-usedLan;
    }

    static int find(int x){
        if(parent[x]==x){
            return x;
        }
        else return find(parent[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x>y){
            parent[x] = y;
        }else{
            parent[y] = x;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        for(int j=0; j<N; j++){
            String s = br.readLine();
            for(int i=0; i<N; ++i){
                int n = (int)s.charAt(i);
                if(n>=97 && n<=122) n = n-96;
                else if(n>=65 && n<=90) n = n-38;
                else if(n==48) n = 0;

                if(n!=0) q.offer(new Edge(j, i, n));
                total+=n;

            }
        }

        bw.write(String.valueOf(MST()));
        bw.flush();
        bw.close();

    }
}