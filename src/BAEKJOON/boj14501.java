package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj14501 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n+1];
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if(i+t[i] <= n+1){
                for (int j = 0; j < i; j++) {
                    if(j+t[j] <=i){
                        dp[i] = Math.max(dp[i], dp[j]+p[i]);
                    }
                }
            }
            result = Math.max(dp[i],result);
        }
        System.out.println(result);
    }
}
