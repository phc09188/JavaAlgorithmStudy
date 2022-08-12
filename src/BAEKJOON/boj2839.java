package BAEKJOON;

import java.io.*;
public class boj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt=0;
        int n = Integer.parseInt(br.readLine());
        while(true){
            if(n%5 == 0){
                cnt+=n/5;
                System.out.println(cnt);
                return;
            }else{
                n -=3;
                cnt++;
            }
            if(n<0){
                System.out.println(-1);
                return;
            }
        }
    }
}
