package Programmerslv1;

public class 가운데글자가져오기 {
    public String solution(String s) {
        int length = s.length();
        if(length%2 ==0) return s.substring(length/2-1, length/2+1);
        return s.charAt(length/2)+"";
    }

    public static void main(String[] args) {
        가운데글자가져오기 a = new 가운데글자가져오기();
        System.out.println(a.solution("qwer"));
    }
}
