package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1013 {
    static StringBuilder sb = new StringBuilder();
    private static final String pattern = "(100+1+|01)+";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n --> 0){
            String test = br.readLine();
            if(test.matches(pattern)) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb.toString());
        br.close();
    }
}