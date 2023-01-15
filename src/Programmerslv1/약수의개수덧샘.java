package Programmerslv1;

import java.util.Enumeration;

public class 약수의개수덧샘 {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int cur = divisor(i);
            if(cur%2 == 0) answer+=i;
            else answer-=i;
        }
        return answer;
    }
    public int divisor(int number){
        int cnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if(i * i == number) cnt++;
            else if(number%i ==0) cnt+=2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        약수의개수덧샘 a = new 약수의개수덧샘();
        System.out.println(a.solution(13,17));
    }
}
