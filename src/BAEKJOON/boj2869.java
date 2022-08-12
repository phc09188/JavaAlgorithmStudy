package BAEKJOON;

import java.io.*;
import java.util.StringTokenizer;

public class boj2869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int sec = A-B;
        int cnt = (V-A)/sec;
        if((V-A)%sec != 0) {
            System.out.println(cnt+2);
        }else{
            System.out.println(cnt+1);
        }
    }
}
