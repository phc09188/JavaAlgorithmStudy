package Programmerslv2;

import java.util.*;
public class N개의최소공배수 {
    public static int solution(int[] arr) {
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = lcd(answer, arr[i]);
        }
        return answer;
    }
    public static int gcd(int a, int b){
        if(a%b ==0){
            return b;
        }
        return gcd(b,a%b);
    }
    public static int lcd (int a, int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args){
        int[] arr1 = {2,6,8,14};
        int[] arr2 = {1,2,3};
    }
}
