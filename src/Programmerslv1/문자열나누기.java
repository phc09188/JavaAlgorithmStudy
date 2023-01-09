package Programmerslv1;

public class 문자열나누기 {
    public int solution(String s) {
        char first = s.charAt(0);
        int count = 0;
        int diff = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count == diff) {
                answer++;
                first = s.charAt(i);
            }
            if (first == s.charAt(i)) {
                count++;
            } else {
                diff++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열나누기 a = new 문자열나누기();
        System.out.println(a.solution("aaabbaccccabba"));
    }
}
