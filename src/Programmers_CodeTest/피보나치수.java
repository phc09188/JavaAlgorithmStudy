package Programmers_CodeTest;

import java.util.*;

public class 피보나치수 {
    public static int solution(int n) {
        int answer = 0;
        int num1 =1;
        int num2 = 1;
        if(n==0 || n==1) return 1;
        else{
            for(int i = 1; i<n; i++){
                answer = (num1 + num2) % 1234567;
                num1 = num2;
                num2 = answer;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(solution(4));
    }
}
