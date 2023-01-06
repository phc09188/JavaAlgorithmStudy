package Programmerslv1;

public class 푸드파이터대회 {

    public String solution(int[] food) {
        String answer = "";
        for (int i = 1; i < food.length; i++) {
            int cnt = food[i]/2;
            for (int j = 0; j < cnt; j++) {
                answer += i;
            }
        }
        answer += "0";
        for (int i = answer.length()-2; i >= 0; i--) {
            answer += answer.charAt(i);
        }
        return answer;
    }
    
    public static void main(String[] args) {
        푸드파이터대회 a = new 푸드파이터대회();
        int[] food = {1,3,4,6};
        System.out.println(a.solution(food));
    }
}
