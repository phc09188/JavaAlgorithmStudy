package codeTest;

import java.io.*;
import java.util.*;
public class boj2805 {
    public static long search(int[] input, int n ,int m, int a){
        int first = 0;
        int last = a;
        while(first <= last){
            int mid = (first +last) / 2;
            long result = 0;
            for (int i = 0; i < input.length; i++) {
                int b = input[i] - mid;
                if(b>0){
                    result += b;
                }
            }
            if(m <= result){
                first = mid +1;
            }else{
                last = mid -1;
            }
        }
        return last;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] input = new int[n];
        int a = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            a = Math.max(a, input[i]);
        }

        System.out.println(search(input, n, m, a));
    }
}
