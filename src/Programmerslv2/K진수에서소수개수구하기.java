package Programmerslv2;

import java.util.ArrayList;
import java.util.List;

public class K진수에서소수개수구하기 {
    public static boolean isprime(long n){
        if(n <= 1) return false;
        else if(n == 2) return true;
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }
    public static String toKnum(int n, int k) {
        String res = "";
        while(n > 0) {
            res = n % k + res;
            n /= k;
        }
        return res;
    }
    public static int solution(int n, int k) {
        int answer = 0, i, j;
        String s = toKnum(n,k);
        for(i = 0; i < s.length(); i = j) {
            for(j = i + 1; j < s.length() && s.charAt(j) != '0'; j++);
            if(isprime(Long.parseLong(s.substring(i,j))))
                answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(437674,3));
    }
}
