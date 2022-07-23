package codeTest;

import java.io.*;
import java.util.*;
public class boj1106 {
    static int c;
    static int n;
    static int[] value;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        value = new int[c+101];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[0] = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            for (int j = reward; j < c+101; j++) {
                int prev = value[j-reward];
                if(prev!= Integer.MAX_VALUE){
                    value[j] = Math.min(value[j], cost+prev);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = c; i < c+101; i++) {
            min = Math.min(min,value[i]);
        }
        System.out.println(min);
    }
}
