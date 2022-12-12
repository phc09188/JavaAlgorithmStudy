package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1629 {
    static long c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        System.out.println(pow(a,b));
    }
    public static int pow(long a, long b){
        if(c == 1){
            return (int) (a %c);
        }
        long temp = pow(a, b/2);
        if(b %2 == 1){
            return (int) ((temp*temp %c) * a %c);
        }
        return (int) (temp*temp%c);
    }
}
