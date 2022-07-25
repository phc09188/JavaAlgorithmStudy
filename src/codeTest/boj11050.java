package codeTest;

import java.io.*;
import java.util.StringTokenizer;

public class boj11050 {
    public static int pactorial(int n ){
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *=i;
        }
        return sum;
    }
    public static int Combination(int n, int k){
        if(k>n || k<0){
            return 0;
        }else {
            return pactorial(n) / (pactorial(n - k) * pactorial(k));
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        System.out.println(Combination(n,k));
    }
}
