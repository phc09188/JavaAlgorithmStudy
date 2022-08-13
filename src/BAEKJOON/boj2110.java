package BAEKJOON;

import java.util.*;
import java.io.*;
public class boj2110 {
    static int[] homes;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  int C = Integer.parseInt(st.nextToken());
        homes = new int[N];
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        int first = 1; int last = homes[homes.length-1] - homes[0] +1;
        while(first<last){
            int mid = (first + last)/2;
            if(Install(mid) < C) last = mid;
            else first = mid +1;
        }
        System.out.println(first-1);
    }
    public static int Install(int distance){
        int cnt = 1;  int last = homes[0];
        for (int i = 1; i < homes.length; i++) {
            int cur = homes[i];
            if(cur - last >= distance){
                cnt++; last = cur;
            }
        }
        return cnt;
    }
}
