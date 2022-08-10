package Programmerslv4;

import java.util.*;
public class 징검다리 {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        long answer = 0;
        long left = 1;
        long right = distance;
        while(left <= right){
            long mid =(left + right) /2; int cnt = 0; int pre = 0;
            for (int i = 0; i < rocks.length; i++) {
                if(rocks[i] - pre < mid){
                    cnt++;
                }else{
                    pre = rocks[i];
                }
            }
            if(distance - pre < mid) cnt++;
            if(cnt <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return (int)answer;
    }

    public static void main(String[] args){
        int[] rocks = {2, 14, 11, 21, 17};
        System.out.println(solution(25, rocks,2));
    }
}
