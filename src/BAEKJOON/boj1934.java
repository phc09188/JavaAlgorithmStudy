package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj1934 {
    public static int gcd(int a, int b){
        if(a%b ==0){
            return b;
        }
        return gcd(b, a%b);
    }
    public static int solution(int a, int b){
        if(a == 1){
            return b;
        }
        int gcd = gcd(a,b);
        int lcm = a*b/gcd;

        return lcm;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(solution(a,b) + "\n");
        }
        System.out.println(sb);
    }
}
