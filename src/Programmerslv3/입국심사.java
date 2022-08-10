package Programmerslv3;

import java.util.*;
public class 입국심사 {
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
    public static void main(String[] args){
        int[] times = {7,10};
        System.out.println(solution(6,times));
    }
}
