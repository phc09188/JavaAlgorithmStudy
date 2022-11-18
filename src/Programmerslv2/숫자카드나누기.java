package Programmerslv2;

import java.util.*;
public class 숫자카드나누기 {
    public static int solution(int[] arrayA, int[] arrayB) {
        ArrayList<Integer> listA = divisor(arrayA);
        ArrayList<Integer> listB = divisor(arrayB);
        int a = getMaxNonDivisor(arrayB, listA);
        int b = getMaxNonDivisor(arrayA, listB);
        return Math.max(a,b);
    }
    public static int getMaxNonDivisor(int[] arrays, List<Integer> divisors) {
        int target = 0;
        for (int divisor : divisors) {
            boolean isNoDivide = true;
            for (int number : arrays) {
                if (number % divisor == 0) {
                    isNoDivide = false;
                    break;
                }
            }
            if (isNoDivide) {
                target = Math.max(target, divisor);
            }
        }
        return target;
    }


    private static boolean check(Integer a, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] % a != 0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> divisor(int[] array){
        int n = array[0];
        int sqrt = (int) Math.sqrt(n);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= sqrt; i++){
            if(n % i == 0){
                if(check(i,array)) {
                    arr.add(i);
                }
                if(check(n/i,array)){
                    arr.add(n / i);
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {14,35,119}; int[] arr2 = {18,30,102};
        System.out.println(solution(arr1,arr2));
    }
}
