package Programmerslv1;

public class 콜라문제 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n>=a){
            if(n%a== 0){
                n = n/a;
                answer += n * b;
            }else{
                int res = n%a;
                n = n/a;
                answer += n * b;
                n += res;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        콜라문제 a = new 콜라문제();
        System.out.println(a.solution(9,1,20));
    }
}
