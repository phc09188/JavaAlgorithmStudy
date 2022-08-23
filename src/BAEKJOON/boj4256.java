package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class boj4256 {
    static int[] pre, in;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            pre = new int[n+1];  in = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pre[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                in[j] = Integer.parseInt(st.nextToken());
            }
            traversal(0,0,n);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void traversal(int root, int s, int e){
        int rootIdx = pre[root];
        for (int i = s; i < e; i++) {
            if(in[i] == rootIdx){
                traversal(root+1, s,i);
                traversal(root+1+i-s, i+1, e);
                sb.append(rootIdx + " ");
            }
        }
    }
}
