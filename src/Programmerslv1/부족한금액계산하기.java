package Programmerslv1;

public class 부족한금액계산하기 {

    public long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i <= count; i++) {
            int cur = price*i;
            answer += cur;
        }
        if(money < answer) return answer-money;
        else return 0;
    }
    public static void main(String[] args) {
        부족한금액계산하기 a = new 부족한금액계산하기();
        System.out.println(a.solution(3,20, 4));
    }
}
