package Programmerslv1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        for (int i = 0; i < phone_number.length()-4; i++) {
            answer += '*';
        }
        return answer + phone_number.substring(phone_number.length()-5);
    }
}
