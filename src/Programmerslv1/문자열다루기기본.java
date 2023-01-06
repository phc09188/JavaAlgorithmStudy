package Programmerslv1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        if(s.length()!=4 && s.length() !=6) return false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(cur<'0' || cur>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        문자열다루기기본 a = new 문자열다루기기본();
        System.out.println(a.solution("1234"));
    }

}
