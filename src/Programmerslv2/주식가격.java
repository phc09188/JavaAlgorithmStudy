package Programmerslv2;

import java.util.*;
public class 주식가격 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[i] <= prices[j]) answer[i]++;
                else{
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        int[] prices = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(prices)));
    }
}
