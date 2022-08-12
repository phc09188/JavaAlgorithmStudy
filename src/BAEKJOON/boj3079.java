package BAEKJOON;

import java.io.*;
import java.util.*;
public class boj3079 {
    public static void main(String[] args ) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); int M = Integer.parseInt(st.nextToken());
        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(M,times));
    }
    public static long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        Arrays.sort(times);
        long right = times[times.length-1] * n;
        while(left<= right){
            long mid = (left + right)/2;
            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += mid/times[i];
            }
            if(sum <n){
                left = mid +1;
            }else{
                right = mid -1;
                answer = mid;
            }
        }
        return answer;
    }
}
